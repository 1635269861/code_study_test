package yingtailai;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-10 13:47
 */
public class Test3 {

    public static void main(String[] args) {
        int sheeps = getSheeps(2, 4, 5, 15);
        System.out.println(sheeps);
    }

    /**
     *
     * @param num1 表示那一年生产
     * @param num2  表示哪一年生产
     * @param dead  表示羊在哪一年死亡
     * @param n 表示羊的生命周期
     * @return
     */
    public static int getSheeps(int num1,int num2, int dead, int n){
        int arr[] = {num1,num2};
        ArrayList<Sheep> sheeps = new ArrayList<>();
        sheeps.add(new Sheep());

        ArrayList<Sheep> addSheeps = new ArrayList<>();
        ArrayList<Sheep> delSheeps = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (Sheep sheep : sheeps) {
                for (int j = 0; j < arr.length; j++) {
                    if(sheep.age == arr[j]){
                        Sheep s = new Sheep();
                        s.age++;
                        addSheeps.add(s);
                    }
                }
                if(sheep.age == dead){
                    delSheeps.add(sheep);
                }
                sheep.age++;
            }
            sheeps.addAll(addSheeps);
            sheeps.removeAll(delSheeps);
            addSheeps.clear();
            delSheeps.clear();
        }
        return sheeps.size();
    }

}

class Sheep{
    public int age = 1;//默认一只羊的年龄为1
}
