package com.bjpowernode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

/**
 * @李永琪
 * @create 2020-09-27 21:20
 */
public class Test {

    //用字符串计算两个数字的和
//    public static void main(String[] args) {
//        String s1 = "23456";
//        String s2 = "456789";
//        String s = test1(s1, s2);
//        System.out.println(s);
//    }

    public static String test1(String str1,String str2){
        //找到两个字符串中的最大的值
        int maxLen = Math.max(str1.length(), str2.length());

        //将两个字符串前面的数字补零
        if(str1.length() < str2.length()){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str2.length() - str1.length(); i++) {
                builder.append(0);
            }
            str1 = builder.toString() + str1;
        }else{
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str1.length() - str2.length(); i++) {
                builder.append(0);
            }
            str2 = builder.toString() + str2;
        }
        int[] result = new int[maxLen + 1];
        for(int i = maxLen - 1; i >= 0; --i){
            int i1 = Integer.parseInt(str1.charAt(i) + "");
            int i2 = Integer.parseInt(str2.charAt(i) + "");
            int i3 = i1 + i2 + result[i + 1];
            //个位的数字
            int i4 = i3 % 10;
            //取十位的数字
            int i5 = i3 / 10;
            result[i + 1] = i4;
            result[i] = i5;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if(i == 0 && result[i] == 0){
                continue;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    @org.junit.Test
    public void test1(){
        HashMap<String, String> map = new HashMap<>();
        map.put(null,"111");
        String s = map.get(null);
        System.out.println(s);

//        Hashtable<String, String> table = new Hashtable<>();
//        table.put("123",null);
//        table.get("123");
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null,"St");
//        System.out.println(concurrentHashMap.get(null));
    }

    @org.junit.Test
    public void test2(){
        SingleLeton instance = SingleLeton.getInstance();
        SingleLeton instance1 = SingleLeton.getInstance();
        System.out.println(instance == instance1);
    }

    public static void main(String[] args){
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        List<String> list1 = new ArrayList<>();
//        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    list1.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list1);
                }
            }).start();
        }


    }

}

class SingleLeton{
    private static SingleLeton instance;

    private SingleLeton() {

    }

    public static SingleLeton getInstance(){
        if(instance == null){
            synchronized (SingleLeton.class){
                if(instance == null){
                    instance = new SingleLeton();
                }
            }
        }
        return instance;
    }
}
