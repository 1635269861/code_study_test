package com.bjpowernode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @李永琪
 * @create 2020-10-17 23:13
 */
public class JDKProxy implements InvocationHandler {

    //创建的目标对象
    private Object obj;

    public JDKProxy(Object obj) {
        this.obj = obj;
    }

    //获取动态对象的方法
    public Object getProxy(){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("执行方法之前");
        Object invoke = method.invoke(obj, args);
        System.out.println("执行方法之后");

        return invoke;
    }
}
