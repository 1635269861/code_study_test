package com.bjpowernode.alogrim;

/**
 * @李永琪
 * @create 2020-09-15 21:05
 */
public class ViolenceMatch {

    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "orld";
        int i = violenceMatch(str1, str2);
        System.out.println("index = " + i);
    }

    public static int violenceMatch(String str1,String str2){
        //判断str2是否包含str1
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2){
            if(chars1[i] == chars2[j]){
                i++;
                j++;
            }else{
                j = 0;
                i = i - j + 1;
            }
        }
        if(j == len2){
            return i - j;
        }else{
            return -1;
        }
    }

}
