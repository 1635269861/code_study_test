package com.bjpowernode.niuke;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * @李永琪
 * @create 2020-09-20 23:00
 */
public class FirstNotRepeatingChar {

    //在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
    // 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }

        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }

}
