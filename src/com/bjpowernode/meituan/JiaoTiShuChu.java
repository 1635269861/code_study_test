package com.bjpowernode.meituan;

import java.util.concurrent.locks.LockSupport;

/**
 * @李永琪
 * @create 2020-10-11 22:58
 */
public class JiaoTiShuChu {

    private static Thread t1;
    private static Thread t2;

    /**
     * 两个线程交替打印字符串
     * @param args
     */
    public static void main(String[] args) {
        char[] nums = "1234567".toCharArray();
        char[] chars = "ABCDEFG".toCharArray();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char num : nums) {
                    System.out.println(num);
                    LockSupport.unpark(t2);//叫醒第二个线程
                    LockSupport.park();//阻塞当前线程
                }
            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char aChar : chars) {
                    LockSupport.park();//阻塞当前线程
                    System.out.println(aChar);
                    LockSupport.unpark(t1);//叫醒第一个线程
                }
            }
        });

        t1.start();
        t2.start();
    }

}
