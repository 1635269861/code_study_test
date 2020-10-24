package com.bjpowernode.annotationreflection;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-17 11:04
 */
public class Test1 {

    @Deprecated
    public static void test1(){
        System.out.println("11111");
    }

    @Override
    public String toString() {
        return "Test1{}";
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test2(){
        ArrayList<String> list = new ArrayList<>();
    }
}
