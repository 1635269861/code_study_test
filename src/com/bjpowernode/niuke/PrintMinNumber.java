package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-09-21 12:54
 */
public class PrintMinNumber {


    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    // 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
    public String PrintMinNumber(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                int v1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int v2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if(v2 < v1){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

}
