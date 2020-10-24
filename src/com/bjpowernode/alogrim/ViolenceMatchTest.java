package com.bjpowernode.alogrim;

/**
 * @李永琪
 * @create 2020-09-15 22:58
 */
public class ViolenceMatchTest {

    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "orld";
        int i = violenceMatchTest(str1, str2);
        System.out.println(i);
    }

    public static int violenceMatchTest(String str1, String str2){
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
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        if(j == len2){
            return i - j;
        }else{
            return -1;
        }
    }

}
