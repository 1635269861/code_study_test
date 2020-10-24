package com.bjpowernode.alogrithmtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-09-17 10:34
 */
public class GreedyAlogrithm {

    public static void main(String[] args) {
        //创建一个map用来表示广播台的编号和覆盖的地区
        //覆盖的地区用HashSet表示
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("上海");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //创建一个set用于保存全部的城市
        HashSet<String> allAreas = new HashSet<>();
        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);

        map.put("K1",hashSet1);
        map.put("K2",hashSet2);
        map.put("K3",hashSet3);
        map.put("K4",hashSet4);
        map.put("K5",hashSet5);

        //定义一个临时set，用来保存当前广播台与要求的地区的交集
        HashSet<String> tempSet = new HashSet<>();
        
        //创建一个结果集，用来表示最后的结果
        ArrayList<String> selects = new ArrayList<>();

        //定义一个maxKey，每次遍历的都是第一个
        String maxKey = null;
        while (allAreas.size() > 0){
            maxKey = null;
            for (String key : map.keySet()) {
                tempSet.clear();
                HashSet<String> areas = map.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);

                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > map.get(maxKey).size())){
                    maxKey = key;
                }
            }

            if(maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(map.get(maxKey));
            }
        }
        System.out.println(selects);
    }

}
