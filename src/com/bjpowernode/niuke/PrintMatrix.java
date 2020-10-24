package com.bjpowernode.niuke;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-09-07 16:49
 */
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] arr = { {1,2, 3 ,4},
                {5 ,6, 7, 8 },{9, 10, 11, 12},{ 13, 14, 15, 16}};
        ArrayList<Integer> integers = new PrintMatrix().printMatrix(arr);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(true){
            //最上面一行
            for(int col = left; col <= right; ++col){
                list.add(matrix[up][col]);
            }
            //up+1
            up++;
            //判断up和down是否交互
            if(up > down){
                break;
            }
            //最后边的列
            for(int row = up; row <= down; ++row){
                list.add(matrix[row][right]);
            }
            //right-
            right--;
            //判断left和right是否交错
            if(left > right){
                break;
            }
            //输出最下面的一行
            for(int col = right; col >= left; col--){
                list.add(matrix[down][col]);
            }
            //down--
            down--;
            //判断down和up是否交互
            if(up > down){
                break;
            }
            //输出最左边的一列
            for(int row = down; row >= up; row--){
                list.add(matrix[row][left]);
            }
            //left-
            left++;
            if(left > right){
                break;
            }
        }
        return list;
    }

}
