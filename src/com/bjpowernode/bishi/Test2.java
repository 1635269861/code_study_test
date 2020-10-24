package com.bjpowernode.bishi;

/**
 * @李永琪
 * @create 2020-10-09 10:57
 */
public class Test2 {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        StringBuffer stringBuffer = new StringBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    stringBuffer.append("a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        stringBuffer.append("2");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2){
                    stringBuffer.append("5");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        stringBuffer.append("6");
                    }
                }
            }
        }).start();
    }

}
