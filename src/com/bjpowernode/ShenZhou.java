package com.bjpowernode;



/**
 * @李永琪
 * @create 2020-09-15 15:30
 */
public class ShenZhou {

    public static void main(String[] args) {
        String s = longestPalindrome("");
        System.out.println(s);
    }

    public static String longestPalindrome (String s) {
        // write code here
        if(s == null){
            return null;
        }
        int len = s.length();
        String result = "";
        if(len % 2 == 0){
            for (int i = 0; i < len / 2; i++) {
                String substring1 = s.substring(i, len / 2);
                String substring2 = s.substring(len / 2, len - i);
                StringBuilder stringBuilder = new StringBuilder(substring1);
                String s1 = stringBuilder.reverse().toString();
                if(s1.equals(substring2)){
                    result = substring1 + substring2;
                    break;
                }
            }
        }else{
            for (int i = 0; i < len / 2; i++) {
                String substring1 = s.substring(i, len / 2);
                String substring2 = s.substring(len / 2 + 1, len - i);
                StringBuilder stringBuilder = new StringBuilder(substring1);
                String s1 = stringBuilder.reverse().toString();
                if(s1.equals(substring2)){
                    String s2 = "" + s.charAt(len / 2);
                    result =  substring1 + s2 +  substring2;
                    break;
                }
            }
        }
        return result;
    }

}
