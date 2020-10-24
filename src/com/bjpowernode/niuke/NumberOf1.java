package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-09-07 9:49
 */
public class NumberOf1 {

    public static void main(String[] args) {
        int i = numberOf1(-78);
        System.out.println(i);
    }

    public static int numberOf1(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n = n & (n - 1);
        }
        return count;
    }

}
