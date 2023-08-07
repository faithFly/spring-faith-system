package com.faith.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //运行时间
@Target(ElementType.TYPE)//只能写在类上面
public @interface ComponentScan {
    String value() default "" ;
}
