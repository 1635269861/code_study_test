package com.bjpowernode.niuke;

import java.util.HashMap;

/**
 * @李永琪
 * @create 2020-09-21 13:01
 */
public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }else{
                map.put(array[i],1);
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(map.get(array[i]) == 1){
                if(count == 0){
                    num1[0] = array[i];
                    count++;
                }else{
                    num2[0] = array[i];
                }
            }
        }
    }

}
