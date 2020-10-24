package com.bjpowernode.alogrim;

import com.sun.xml.internal.ws.message.PayloadElementSniffer;

/**
 * @李永琪
 * @create 2020-09-14 23:40
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数

        //创建二位数组，每个格子表示能放下的物品的最大值，其中第一行和第一列为0
        int[][] arr = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        for (int j = 0; j < arr[0].length; j++) {
            arr[0][j] = 0;
        }
        for(int i = 0;i < arr.length; ++i){
            arr[i][0] = 0;
        }

        //放置商品，格子的重量小于物品的重量时
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                //公式
                if(w[i - 1] > j){
                    arr[i][j] = arr[i - 1][j];
                }else{
                    arr[i][j] = Math.max(arr[i - 1][j], val[i - 1] + arr[i - 1][j - w[i - 1]]);
                    if(val[i - 1] + arr[i - 1][j - w[i - 1]] > arr[i - 1][j]){
                        path[i][j] = 1;
                    }
                }
            }
        }
        
        //倒叙遍历二维数组
        int i = path.length - 1;
        int j = path[0].length - 1;
       while (i > 0 && j > 0){
           if(path[i][j] == 1){
               System.out.println("加入了第" + i + "个商品");
                j -= w[i - 1];
           }
           i--;
       }

        for (int mz = 0; mz < arr.length; mz++) {
            for (int y = 0; y < arr[mz].length; y++) {
                System.out.print(arr[mz][y] + "  ");
            }
            System.out.println();
        }

        for (int k = 0; k < path.length; k++) {
            for (int l = 0; l < path[i].length; l++) {
                System.out.print(path[k][l] + " ");
            }
            System.out.println();
        }
    }

}
