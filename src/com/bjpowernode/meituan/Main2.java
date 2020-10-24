package com.bjpowernode.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @李永琪
 * @create 2020-09-27 10:30
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String next = scanner.next();
        if(next.length() != i){
            throw new RuntimeException("输入的长度和字符串的长度不相等！");
        }
        int maxLength = getMaxLength(next);
        System.out.println(maxLength);
    }

    public static int getMaxLength(String str){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                int countOfE = 0;
                int countOfF = 0;
                for (int k = 0; k < substring.length(); k++) {
                    if(substring.charAt(k) == 'E'){
                        countOfE++;
                    }
                    if(substring.charAt(k) == 'F'){
                        countOfF++;
                    }
                }
                int temp = Math.abs(countOfE - countOfF);
                list.add(temp);
            }
        }

        int max = list.get(0);
        for (Integer integer : list) {
            if(integer > max){
                max = integer;
            }
        }
        return max;
    }

}
