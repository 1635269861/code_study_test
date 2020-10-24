package com.bjpowernode.niuke;

import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-07 13:48
 */
public class LastRemainingSolution {


    public int LastRemaining_Solution(int n, int m) {
        if(n < 0 || m < 0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int cur = -1;
        while (list.size() > 1){
            for (int i = 0; i < m; i++) {
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            list.remove(cur);
            cur--;
        }
        return list.get(0);
    }

}
