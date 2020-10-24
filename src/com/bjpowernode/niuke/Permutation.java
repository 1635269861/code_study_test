package com.bjpowernode.niuke;

import java.util.*;

/**
 * @李永琪
 * @create 2020-09-08 15:08
 */
public class Permutation {

    public static void main(String[] args) {
        ArrayList<String> abc = permutation("aab");
        for (String s : abc) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> permutation(String str){
        ArrayList<String> strList = new ArrayList<>();
        if(str.isEmpty()){
            return strList;
        }
        perm(0,strList,new StringBuffer(str));
        Set<String> set = new TreeSet<>();
        set.addAll(strList);
        ArrayList<String> strs = new ArrayList<>();
        strs.addAll(set);
        return strs;
    }

    public static void perm(int pos,ArrayList<String> strList,StringBuffer s){
        if(pos + 1 == s.length()){
            strList.add(s.toString());
            return;
        }
        for(int i = pos; i < s.length(); ++i){
            //交换位置
            char temp = s.charAt(i);
            s.setCharAt(i,s.charAt(pos));
            s.setCharAt(pos,temp);
            perm(pos + 1,strList,s);
            char temp1 = s.charAt(i);
            s.setCharAt(i,s.charAt(pos));
            s.setCharAt(pos,temp1);
        }
    }

}
