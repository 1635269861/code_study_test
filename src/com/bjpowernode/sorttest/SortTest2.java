package com.bjpowernode.sorttest;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-11 23:04
 */
//测试各种排序算法
public class SortTest2 {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
//        bubbleSort(arr);
//
//        selectSort(arr);
//
//        insertSort(arr);
//
//        shellSort(arr);

        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //交换
                if(arr[j + 1] < arr[j]){
                    flag = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(flag){
                flag = !flag;
            }else{
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    //每次挑选出数据放到前面的有序数组种
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            if(min != arr[i]){//说明已经发生了交换位置
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int min = arr[i - 1];
                int index = i - 1;
                while (index >= 0 && arr[index] > arr[i]){
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[index + 1] = temp;//后移数据
                    index--;
                }
        }
        System.out.println(Arrays.toString(arr));
    }

    //希尔排序
    public static void shellSort(int[] arr){
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < arr.length; j+=gap) {
                    int min = arr[j - gap];
                    int index = j - gap;
                    while (index >= 0 && arr[j] < min){
                        int temp = arr[index];
                        arr[index] = arr[j];
                        arr[index + 1] = temp;
                        index -= gap;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int[] arr,int start,int end){
        int privoit = arr[start];
        int i = start;
        int j = end;

        while (i < j){
            while (i < j && arr[i] < privoit){
                i++;
            }

            while (i < j && arr[j] > privoit){
                j--;
            }
            if(i < j && arr[i] == arr[j]){
                i++;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        if(i - 1 > start){
            quickSort(arr,start,i - 1);
        }
        if(j + 1 < end){
            quickSort(arr,j+1,end);
        }
    }
}
