package leetcode;

import java.util.Arrays;

/**
 * @李永琪
 * @create 2020-10-16 21:51
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        int[] ints = sortedSquares(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] sortedSquares(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }

        Arrays.sort(res);
        return res;
    }

}
