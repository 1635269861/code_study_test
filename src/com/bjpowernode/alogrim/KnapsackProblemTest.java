package com.bjpowernode.alogrim;

/**
 * @李永琪
 * @create 2020-09-15 20:31
 */
public class KnapsackProblemTest {

    public static void main(String[] args) {
        int[] w = {1,4,3};
        int[] val = {1500,3000,2000};
        int m = 4;//背包的容量
        int n = w.length;//物品的个数
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列未0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //给每一行每一列赋值
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if(w[i -1] > j){
                    v[i][j] = v[i - 1][j];
                }else{
                    v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][m - w[i - 1]]);
                    if(val[i - 1] + v[i - 1][m - w[i - 1]] > v[i - 1][j]){
                        path[i][j] = 1;
                    }
                }
            }
        }
        int z = path.length - 1;
        int y = path[0].length - 1;
        while (z >0 && y > 0){
            if(path[z][y] == 1){
                System.out.println("加入了" + z + "个商品");
                y -= w[z - 1];
            }
            z--;
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

}
