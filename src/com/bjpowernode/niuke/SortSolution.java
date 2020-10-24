package com.bjpowernode.niuke;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @李永琪
 * @create 2020-10-06 21:46
 */
public class SortSolution {

    ArrayList<Integer> list = new ArrayList<Integer>();
    //如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
    // 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        int index = list.size() / 2;
        if(list.size() % 2 == 0){//集合的数量为偶数个
            return ((double) list.get(index) + (double)list.get(index - 1)) / 2;
        }else{
            return (double)list.get(index);
        }
    }

}
