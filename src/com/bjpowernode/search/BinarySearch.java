package com.bjpowernode.search;

/**
 * @李永琪
 * @create 2020-09-06 9:37
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,23,45,56,67,78,89,100};
//        int i = binarySearch(arr, 0, arr.length - 1, -1);
//        System.out.println(i);

        int i = binarySearchNoRecursion(arr, 1);
        System.out.println(i);
    }

    //递归方式查找
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }

    //非递归方式查找
    public static int binarySearchNoRecursion(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == findVal) {
                return mid;
            } else if (findVal > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
