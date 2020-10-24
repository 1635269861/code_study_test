package com.bjpowernode.search;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-09-06 10:24
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
//        System.out.println(Arrays.toString(arr));
        int i = insertValueSearch(arr, 0, arr.length - 1, 78);
        System.out.println(i);
    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        System.out.println("查找次数");
        if(left > right || findVal < arr[left] || findVal > arr[right]){
            return -1;
        }
        int mid = left +(right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if(findVal == arr[mid]){
            return mid;
        }else if(findVal > arr[mid]){
            return insertValueSearch(arr,mid + 1,right,findVal);
        }else {
            return insertValueSearch(arr,left,mid - 1,findVal);
        }
    }

}
