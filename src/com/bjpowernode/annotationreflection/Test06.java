package com.bjpowernode.annotationreflection;

/**
 * @李永琪
 * @create 2020-10-17 23:59
 */
//测试类什么时候进行类的初始化
public class Test06 {

    static {
        System.out.println("Main类被加载了");
    }

    public static void main(String[] args) {
//        Son son = new Son();
        System.out.println(Son.m);
    }

}

class Father{
    static {
        System.out.println("Father类被加载了");
    }

    public Father() {
        System.out.println("Father的构造方法执行");
    }
}

class Son extends Father{
    static int m = 5;
    static {
        System.out.println("Son类被加载了");
    }


    public Son() {
        System.out.println("Son类的构造方法被执行了");
    }
}
