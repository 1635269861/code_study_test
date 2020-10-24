package com.bjpowernode.niuke;

import java.util.Stack;

/**
 * @李永琪
 * @create 2020-09-08 9:48
 */
public class IsPopOrder {

    public static void main(String[] args) {

    }

    public static boolean isPopOrder(int[] pushA,int[] popA){
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length){
            if(pushA[i] != popA[j]){
                st.push(pushA[i]);
                i++;
            }else{
                ++i;
                ++j;
                while (!st.isEmpty() && st.pop() == popA[j]){
                    st.pop();
                    j++;
                }
            }
        }
        return st.isEmpty();
    }

}
