package com.bjpowernode.search;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * @李永琪
 * @create 2020-09-15 15:38
 */
public class ShenZhou2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] ints = pushIntArray(arr, 2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 数组内数据循环平移
     * @param arr int整型一维数组 输入数组
     * @param pushOffset int整型 位移长度
     * @return int整型一维数组
     */
    public static int[] pushIntArray (int[] arr, int pushOffset) {
        //创建一个数组,复制数组
        int[] nums = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            nums[count] = arr[i];
            count++;
        }

        //将最后数保存到临时数组
        int[] temp = new int[pushOffset];
        count = 0;
        for (int i = arr.length - pushOffset; i < arr.length; i++) {
            temp[count] = arr[i];
            count++;
        }

       for (int i = 0; i < arr.length - pushOffset; i++) {
            arr[i + pushOffset] = nums[i];
        }

        for (int i = 0; i < pushOffset; i++) {
            arr[i] = temp[i];
        }
        return arr;
    }

}
