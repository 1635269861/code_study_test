package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-10-03 21:02
 */
public class LeftRotateString {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        String s = leftRotaeString(str, 1);
        System.out.println(s);
    }

    public static String leftRotaeString(String str, int n){
        if(str == null || str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        char[] chars1 =  new char[n];
        for (int i = 0; i < n; i++) {
            chars1[i] = chars[i];
        }
        char[] resChars = new char[str.length()];
        int count = 0;
        for (int i = n; i < chars.length; i++) {
            resChars[count] = chars[i];
            count++;
        }

        for (int i = 0; i < chars1.length; i++) {
            resChars[count] = chars1[i];
            count++;
        }

        String resStr = new String(resChars);
        return resStr;
    }

}
