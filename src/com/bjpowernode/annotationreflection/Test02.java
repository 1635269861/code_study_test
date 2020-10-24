package com.bjpowernode.annotationreflection;

import java.lang.annotation.*;

/**
 * @李永琪
 * @create 2020-10-17 22:56
 */
public class Test02 {

    @MyAnnotation
    public void test1(){

    }

}

//表示该注解可以使用的地点,作用域
@Target(value = ElementType.METHOD)
//表示该注解什么时候有效
@Retention(value = RetentionPolicy.RUNTIME)
//表示是否生成Javadoc文档
@Documented
//表示是否是支持多继承的
@Inherited
@interface MyAnnotation{

}
