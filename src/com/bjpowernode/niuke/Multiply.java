package com.bjpowernode.niuke;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-06 15:03
 */
public class Multiply {

    public static void main(String[] args) {
        int[] A = {1,5,2,6};
        int[] multiply = multiply(A);
        System.out.println(Arrays.toString(multiply));
    }

    public static int[] multiply(int[] A){
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int count = 0;
            int valOfBi = 1;
            while (count < A.length){
                if(i == count){
                    count++;
                    continue;
                }
                valOfBi *= A[count];
                count++;
            }
            B[i] = valOfBi;
        }
        return B;
    }

}
