package com.bjpowernode.designmodel.adpater.classadapter;

/**
 * @李永琪
 * @create 2020-10-23 10:52
 */
public class Client {

    //测试方法是否成功
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VilotageAdapter());
    }

}
