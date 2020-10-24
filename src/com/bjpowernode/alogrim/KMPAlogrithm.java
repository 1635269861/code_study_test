package com.bjpowernode.alogrim;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-09-15 23:03
 */
public class KMPAlogrithm {

    public static void main(String[] args) {
        String str2 = "ABCDABCD";
        int[] next = getNext(str2);
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        int i = kmpAlogrithm(str1, str2, next);
        System.out.println(i);

        System.out.println(Arrays.toString(next));

    }

    //KMP算法
    public static int  kmpAlogrithm(String str1, String str2, int[] next){
        int len1 = str1.length();
        int len2 = str2.length();

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else{
                i = i - next[j] + 1;
                j = 0;
            }
        }
        if(j == len2){
            return i-j;
        }

        return -1;
    }

    //获取部分匹配值表
    public static int[] getNext(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for(int i = 1,j = 0; i < dest.length();++i){
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = next[j - 1];
            }

            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
