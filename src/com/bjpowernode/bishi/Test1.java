package com.bjpowernode.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @李永琪
 * @create 2020-09-08 20:51
 */
public class Test1 {

    public static void main(String[] args) {
        int[] arr = {1,5,8,10,16,19,45};
        insertVal(arr,17);
    }

    public static void insertVal(int[] arr,int target){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; ++i){
            list.add(arr[i]);
        }
        list.add(target);
        int[] nums = new int[arr.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
