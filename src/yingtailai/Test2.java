package yingtailai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @李永琪
 * @create 2020-10-10 12:46
 */
public class Test2 {

    public static void main(String[] args) {
        int[] arr = {5,3,2,8,4};
        ArrayList<List<Integer>> list = getNumOf(arr, 7);
        for (List<Integer> integerList : list) {
            StringBuilder stringBuilder = new StringBuilder();
            Collections.sort(integerList);
            for (int i = 0; i < integerList.size(); i++) {
                if(i == integerList.size() - 1){
                    stringBuilder.append(integerList.get(i));
                }else{
                    stringBuilder.append(integerList.get(i) + ",");
                }
            }
            System.out.println(stringBuilder);
        }
    }

    public static ArrayList<List<Integer>> getNumOf(int[] arr, int target){
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(arr== null || arr.length == 0){
            return result;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

}
