package com.bjpowernode.alogrithmtest;

import com.bjpowernode.alogrim.KMPAlogrithm;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-09-15 23:31
 */
public class KMPAlogrithmTest {

    public static void main(String[] args) {
        String str2 = "ABCDABCD";
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        int[] next1 = getNext1(str2);
        int i = kpmAlogrithmTest(str1, str2, next1);
        System.out.println(i);
        System.out.println(Arrays.toString(next1));
    }

    public static int kpmAlogrithmTest(String str1, String str2, int[] next){
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
        return j == len2 ? i - j : -1;
    }

    public static int[] getNext1(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {

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
