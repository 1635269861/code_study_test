package com.bjpowernode.niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @李永琪
 * @create 2020-10-06 15:14
 */
public class Solution {

    String result = "";
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert('g');
        solution.Insert('o');
        solution.Insert('o');
        solution.Insert('g');
        solution.Insert('l');
        solution.Insert('e');
        System.out.println(solution.result);
        System.out.println(solution.FirstAppearingOnce());
    }

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        Set<Character> keySet = map.keySet();
        if(keySet.contains(ch)){
           map.put(ch,map.get(ch) + 1);
        }else{
            map.put(ch,1);
        }
        result += ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            if(map.get(c) == 1){
                int index = result.indexOf(c);
                list.add(index);
            }
        }
        if(list.size() == 0){
            return '#';
        }
        int min = list.get(0);
        for (Integer integer : list) {
            if(integer < min){
                min = integer;
            }
        }
        char c = result.charAt(min);
        return c;
    }

}
