package com.bjpowernode.annotationreflection;

/**
 * @李永琪
 * @create 2020-10-17 23:31
 */
public class Test04 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = Class.forName("com.bjpowernode.annotationreflection.User");
        Class clazz2 = Class.forName("com.bjpowernode.annotationreflection.User");
        Class clazz3 = Class.forName("com.bjpowernode.annotationreflection.User");
//        ClassLoader classLoader = clazz1.getClassLoader();
//        System.out.println(classLoader);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }

}
