package com.bjpowernode.alogrim;

/**
 * @李永琪
 * @create 2020-09-14 21:48
 */
public class HanoiTower {

    public static void main(String[] args) {
        hannoiTower(5,'A','B','C');
    }

    public static void hannoiTower(int num, char a, char b, char c){
        if(num == 1){
            System.out.println("盘子的路径:" + a + "->" + c);
        }else{
            hannoiTower(num - 1,a,c,b);
            System.out.println("第number个盘子:" + a + "->" + c);
            hannoiTower(num - 1, b , a, c);
        }
    }

}
