package com.bjpowernode.annotationreflection;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @李永琪
 * @create 2020-10-17 23:05
 */
public class Test03 {

    @MyAnnotation03(schools = {"西北大学","西工大"},id = 4)
    public void test1(){

    }

}

//定义一个注解
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation03{

    String value() default "all";
    int age() default 5;
    int id() default -1;

    String[] schools();

}
