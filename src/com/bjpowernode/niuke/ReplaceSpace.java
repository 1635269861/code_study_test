package com.bjpowernode.niuke;


/**
 * @李永琪
 * @create 2020-09-17 14:50
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello World");
        String s = replaceSpace(buffer);
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str){
        String s = str.toString();
        String s1 = s.replaceAll(" ", "%20");
        return s1;
    }

}
