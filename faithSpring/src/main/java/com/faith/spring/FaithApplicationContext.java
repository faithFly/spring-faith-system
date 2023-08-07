package com.faith.spring;

import com.faith.server.AppConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description: 手写容器
 * @author:faith
 * @time:2023/7/416:00
 */
public class FaithApplicationContext {
    private Class configClass;
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    //单例池
    private ConcurrentHashMap<String,Object> singletonMap = new ConcurrentHashMap<>();
    public FaithApplicationContext(Class appConfig) {
        this.configClass = appConfig;

        //扫描路径 路径来源就是appConfig配置类上的componentScan注解里的包名
        if (appConfig.isAnnotationPresent(ComponentScan.class)){
            //获取包名 转化城路径进行扫描
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            //获得value中的路径--》com.faith.server
            String path = componentScanAnnotation.value();
            //com.faith.server----> (相对路径)com/faith/server
            path = path.replace(".", "/");
            //拿到类加载器
            ClassLoader classLoader = FaithApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (File f:
                     files) {
                    String fileName = f.getAbsolutePath();
                    if (fileName.endsWith(".class")){
                        try {
                            //拿到class对象判断是否有component注解
                            //com.faith.server.UserServer
                            String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                            className = className.replace("\\",".");
                            Class<?> aClass = classLoader.loadClass(className);
                            if (aClass.isAnnotationPresent(Component.class)) {
                                //获取bean的名字
                                Component annotation = aClass.getAnnotation(Component.class);
                                //Component("userService") ----> userService
                                String beanName = "";
                                if (annotation.value().equals("")){
                                    //获取类名
                                    //Introspector.decapitalize-->获取类名 首字母小写
                                    beanName = Introspector.decapitalize(aClass.getSimpleName());
                                }else{
                                    beanName = annotation.value();
                                }
                                //判断是否包含scope注解
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(aClass);
                                if (aClass.isAnnotationPresent(Scope.class)) {
                                    //设置作用域值
                                    beanDefinition.setScope(aClass.getAnnotation(Scope.class).value());
                                }else {
                                    //默认为单例
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinitionMap.put(beanName,beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }

            }
        }

        // 将map中的单例bean都放到单例池中去
        for (String key:
             beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(key);
            if (beanDefinition.getScope().equals("scope")) {
                //创建bean
                Object bean = createBean(key, beanDefinition);
                singletonMap.put(key,bean);
            }
        }
    }
    //创建bean
    private Object createBean(String beanName,BeanDefinition beanDefinition){
        //获取类的实例化
        Class aClass = beanDefinition.getType();
        try {
            Object bean = aClass.getConstructor().newInstance();
            //获取bean的所有属性 并且包含autowired的 注入属性
            // getDeclaredFields()获取类的所有属性
            for (Field field:
                 aClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    //赋值
                    field.setAccessible(true); //设置权限
                    field.set(bean,getBean(field.getName()));
                }
            }

            //Aware回调
            //判断这个bean是不是实现了BeanNameAware
            if (bean instanceof BeanNameAware){
                //转成beanNameAware 接口 执行setBeanName方法
                ((BeanNameAware)bean).setBeanName(beanName);
            }

            //初始化 回调
            if (bean instanceof InitializingBean){
                //转成InitializingBean接口 执行afterPropSet方法
                ((InitializingBean)bean).afterPropSet();
            }
            return bean;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    //获取bean
    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new NullPointerException();
        }else {
            String scope = beanDefinition.getScope();
            if (scope.equals("singleton")){
                //单例
                Object bean = singletonMap.get(beanName);
                if (bean == null){
                    Object currentBean = createBean(beanName, beanDefinition);
                    singletonMap.put(beanName,currentBean);
                    return currentBean;
                }
                return bean;
            }else{
                //多例
                return createBean(beanName,beanDefinition);
            }
        }
    }
}
