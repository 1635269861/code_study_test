package com.bjpowernode;



import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @李永琪
 * @create 2020-09-24 20:18
 */
public class Main{
    public static void main(String[] args) {
        String sum = getSum("11111111111111111111", "99999999999999999999");
        System.out.println(sum);

    }

    public static String getSum(String a, String b){
        int[] arrC = new int[a.length() + 1];

        for(int i = a.length()-1; i>=0; i--) {
            int ai = Integer.parseInt(a.charAt(i) + "" );
            int bi = Integer.parseInt(b.charAt(i) + "" );
            int ci = arrC[i+1];
            int t = ai + bi + ci;
            arrC[i+1] = t%10;
            arrC[i] = t/10;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i<arrC.length; i++) {
            if(i==0 && arrC[i]==0)
                continue;
            res.append(arrC[i]);
        }
        return res.toString();
    }


}
