package com.bjpowernode.annotationreflection;

/**
 * @李永琪
 * @create 2020-10-18 0:19
 */
public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException {
        //测试类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //获取某些加载器
        System.out.println(new User().getClass().getClassLoader());

        Class clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

    }

}
