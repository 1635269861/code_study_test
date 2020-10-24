package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-09-06 11:26
 */
public class RepalceStr {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        String s = replaceSpace(stringBuffer);
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str){
        String string = str.toString();
        String s = string.replaceAll(" ", "%20");
        return s;
    }

}
