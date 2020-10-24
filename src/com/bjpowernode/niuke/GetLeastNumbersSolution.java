package com.bjpowernode.niuke;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-09-08 11:08
 */
public class GetLeastNumbersSolution {

    public static void main(String[] args) {
        int[] arr = {12,45,0,-1,56,-36};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }



    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

}
