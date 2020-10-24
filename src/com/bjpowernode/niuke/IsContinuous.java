package com.bjpowernode.niuke;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-03 21:28
 */
public class IsContinuous {

    public static void main(String[] args) {
        int[] arr = {1,0,0,5,0};
        boolean continuous = isContinuous(arr);
        System.out.println(continuous);
    }

    //判断衣服扑克牌中的五个数字是不是一个顺子
    public static boolean isContinuous(int[] numbers){
        if(numbers == null || numbers.length == 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];
        int min;
        if(numbers[0] != 0){
            min = numbers[0];
        }else if(numbers[1] != 0){
            min = numbers[1];
        }else if(numbers[2] != 0){
            min = numbers[2];
        }else if(numbers[3] != 0){
            min = numbers[3];
        }else{
            min = numbers[4];
        }
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0){
                set.add(numbers[i]);
            }else{
                count++;
            }
        }
        int size = set.size() + count;
        if(size == 5 && (max - min) < 5){
            return true;
        }else{
            return false;
        }
    }

}
