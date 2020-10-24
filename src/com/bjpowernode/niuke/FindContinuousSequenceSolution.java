package com.bjpowernode.niuke;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-07 11:53
 */
public class FindContinuousSequenceSolution {

    public static void main(String[] args) {
        FindContinuousSequenceSolution solution = new FindContinuousSequenceSolution();
        ArrayList<ArrayList<Integer>> list = solution.findContinuousSequence(100);
        System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i < sum; i++) {
            int j = i;
            int temp = 0;
            while (temp < sum){
                temp += j;
                j++;
            }
            if(temp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    list.add(k);
                }
                result.add(list);
            }
        }
        return result;
    }

}
