package com.bjpowernode.proxy;

/**
 * @李永琪
 * @create 2020-10-17 23:17
 */
public class Test {

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy(new SubjectImpl());
        //获取动态代理对象
        Subject proxy = (Subject)jdkProxy.getProxy();
        proxy.doSomething();
    }

}
