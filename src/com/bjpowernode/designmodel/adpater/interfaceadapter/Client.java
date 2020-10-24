package com.bjpowernode.designmodel.adpater.interfaceadapter;

/**
 * @李永琪
 * @create 2020-10-23 16:50
 */
public class Client {

    public static void main(String[] args) {
        AbsAdapter adapter = new AbsAdapter() {
            @Override
            public void m1() {
                System.out.println("m1方法执行了");
            }
        };

        adapter.m1();

    }

}
