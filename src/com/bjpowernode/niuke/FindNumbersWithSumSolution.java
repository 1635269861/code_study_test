package com.bjpowernode.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-07 11:59
 */
public class FindNumbersWithSumSolution {

    public static void main(String[] args) {

    }

    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == sum){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(array[i]);
                    temp.add(array[j]);
                    list.add(temp);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(list.size() == 0){
            return result;
        }

        int[] numsOf =  new int[list.size()];
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (ArrayList<Integer> arrayList : list) {
            int count = 1;
            for (Integer num : arrayList) {
                count *= num;
            }
            numsOf[index] = count;
            map.put(count,index);
            index++;
        }
        Arrays.sort(numsOf);
        int min = numsOf[0];
        Integer indexOfList = map.get(min);
        result = list.get(indexOfList);
        return result;
    }

}
