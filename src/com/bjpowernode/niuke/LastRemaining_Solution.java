package com.bjpowernode.niuke;

import sun.font.CompositeGlyphMapper;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-04 9:43
 */
public class LastRemaining_Solution {

    public static void main(String[] args) {
        int i = lastRemaining_Solution(5, 3);
        System.out.println(i);
    }

    public static int lastRemaining_Solution(int n, int m){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index;
        while (list.size() != 1){
            index = m % list.size() - 1;
            list.remove(index);
        }
        int result = 0;
        for (Integer integer : list) {
            result = integer;
        }
        return result;
    }

}
