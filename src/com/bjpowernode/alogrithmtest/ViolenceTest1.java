package com.bjpowernode.alogrithmtest;

/**
 * @李永琪
 * @create 2020-09-16 14:04
 */
public class ViolenceTest1 {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABCD";
        int i = violenceTest1(str1, str2);
        System.out.println(i);
    }

    public static int violenceTest1(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();

        int i = 0;
        int j = 0;
        while (i < len1 && j < len2){
            if(str1.charAt(i) == str2.charAt(j)){
                ++i;
                ++j;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == len2){
            return i - j;
        }
        return -1;
    }

}
