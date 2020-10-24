package com.bjpowernode.niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @李永琪
 * @create 2020-10-07 13:56
 */
public class MaxInWindowsSolution {

    public static void main(String[] args) {
        MaxInWindowsSolution solution = new MaxInWindowsSolution();
        int[] arr = {2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = solution.maxInWindows(arr, 3);
        System.out.println(list);
    }

    //获得华东窗口的最大值
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(size > num.length || size == 0){
            return result;
        }

        //移动的次数
        int times = num.length - size + 1;
        for (int i = 0; i < times; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = i,count = 0; count < size; j++,count++) {
                list.add(num[j]);
            }
            Collections.sort(list);
            result.add(list.get(list.size() - 1));
        }
        return result;
    }

}
