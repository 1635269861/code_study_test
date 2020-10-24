package com.bjpowernode.alogrim;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-09-17 9:48
 */
public class GreedyAlogrithm {

    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("天津");

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

        map.put("K1",hashSet1);
        map.put("K2",hashSet2);
        map.put("K3",hashSet3);
        map.put("K4",hashSet4);
        map.put("K5",hashSet5);

        HashSet<String> tempSet = new HashSet<>();
        HashSet<String> allAreas = new HashSet<>();

        allAreas.addAll(hashSet1);
        allAreas.addAll(hashSet2);
        allAreas.addAll(hashSet3);
        allAreas.addAll(hashSet4);
        allAreas.addAll(hashSet5);
        System.out.println(allAreas);
        //用于保存结果
        ArrayList<String> selects = new ArrayList<>();
        String maxKey = null;
        //创建一个临时的集合，用于保存交际
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

        System.out.println("最后的结果为：" + selects);
    }

}
