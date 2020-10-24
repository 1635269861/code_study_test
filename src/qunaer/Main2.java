package qunaer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @李永琪
 * @create 2020-10-14 19:32
 */
public class Main2 {

    public static void main(String[] args) {
        String sortResult = getSortResult("12345678911235#8234589119212");
        System.out.println(sortResult);

    }

    public static String getSortResult(String str){
        String[] strs = str.split("#");
        String str1 = strs[0];
        String str2 = strs[1];
        int len = Math.max(str1.length(),str2.length());

        //将较短的数字用0补全
        if(str1.length() != len){
            int dev = Math.abs(len - str1.length());
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < dev; i++) {
                stringBuilder.append(i);
            }

            stringBuilder.append(str1);
            str1 = stringBuilder.toString();
        }else{
            int dev = Math.abs(len - str2.length());
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < dev; i++) {
                stringBuilder.append(i);
            }

            stringBuilder.append(str2);
            str2 = stringBuilder.toString();
        }

        int[] ai = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            String subs1 = str1.substring(i, i + 1);
            String subs2 = str2.substring(i, 1 + i);

            int i1 = Integer.parseInt(subs1);
            int i2 = Integer.parseInt(subs2);
            int temp = i1 + i2 + ai[i + 1];
            int i3 = temp / 10;
            int i4 = temp % 10;

            ai[i + 1] = i4;
            ai[i] = i3;
        }


        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ai.length; i++) {
            if(ai[i] == 0 && i == 0){
                continue;
            }

            res.append(ai[i]);
        }

       return res.toString();
    }

    @Test
    public void test1(){
        String s = "12345678911235#8234589119212";

    }

}

