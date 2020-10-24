package com.bjpowernode.niuke;

import com.sun.scenario.effect.light.DistantLight;
import sun.awt.image.GifImageDecoder;

/**
 * @李永琪
 * @create 2020-09-21 11:52
 */
public class NumberOf1Between1AndN_Solution {

    public static void main(String[] args) {
    }

    public int numberOf1Between1AndN_Solution(int n){

        int high = n / 10;
        int digit = 1;
        int cur = n % 10;
        int low = 0;
        int result = 0;
        while (high != 0 || cur != 0){
            if (cur == 0){
                result += high * digit;
            }else if(cur == 1){
                result += high * digit + low + 1;
            }else{
                result += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }

        return result;
    }

}
