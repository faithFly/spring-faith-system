package com.faith.server;

import com.faith.spring.*;

/**
 * @description:
 * @author:faith
 * @time:2023/7/416:00
 */
@Component("userService")
@Scope("prototype")
public class UserServer implements BeanNameAware, InitializingBean {
    @Autowired
    private OrderService orderService;

    private  String beanName;
    private  String xxx;
    public void test(){
        System.out.println(orderService);
    }

    @Override
    public void afterPropSet() {
        System.out.println("faith init");
    }


    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println(beanName);
    }


}
