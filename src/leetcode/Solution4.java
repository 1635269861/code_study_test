package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-18 13:53
 */
public class Solution4 {

    public static void main(String[] args) {
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        ArrayList<Integer> resList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
                    break;
                }

                set.add(s.charAt(j));
            }
            resList.add(set.size());
        }

        Collections.sort(resList);

        return resList.get(resList.size() - 1);
    }

    @Test
    public void test1(){
        String s = "abcdefg";
        String substring = s.substring(0, 1);
        System.out.println(substring);
    }

}
