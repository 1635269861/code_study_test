package com.bjpowernode.sorttest;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @李永琪
 * @create 2020-09-21 17:16
 */
public class SortTest1 {

    public static void main(String[] args) {
//        int[] arr = {3,9,-1,10,20};
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        sortTest1(arr);
//        System.out.println(Arrays.toString(arr));

//        selectSortTest1(arr);

//        insertSortTest1(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortTest1(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag){
                flag = false;
            }else{
                break;
            }
        }
    }

    public static void selectSortTest1(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = 0;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(min != arr[i]){
                arr[index] = arr[i];
                arr[i] = min;
            }

        }
    }

    public static void insertSortTest1(int[] arr){
        for (int i = 1; i < arr.length - 1; i++) {
            int j;
            for (j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

    }

    public static void shellSort(int[] arr){
        int gap = arr.length;
        while (true){
            gap /= 2;
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j+=gap) {
                    int temp = arr[j];
                    int k = j - gap;
                    while (k >=0 && arr[k] > temp){
                        arr[j] =arr[k];
                        k -= gap;
                    }
                    arr[k + gap] = temp;
                }
            }
            if (gap == 1){
                break;
            }
        }
    }

}
