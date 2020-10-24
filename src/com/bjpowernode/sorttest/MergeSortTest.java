package com.bjpowernode.sorttest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-07 10:54
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] arr = {5,4,3,6,7,1,0,2,8};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //归并的过程
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            //向左进行递归进行归并
            mergeSort(arr,left,mid,temp);
            //向右进行递归归并
            mergeSort(arr,mid + 1,right,temp);
            //进行排序
            merge(arr,left,mid,right,temp);
        }
    }

    //排序的过程
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;//左指针
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }

        while (j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp数组拷贝到arr数组
        t = 0;
        int tempLeft = left;
        System.out.println("left = " + tempLeft + ",right = " + right);
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

}
