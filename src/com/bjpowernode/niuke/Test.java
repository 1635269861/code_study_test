package com.bjpowernode.niuke;


import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-09-17 14:54
 */
public class Test {

    public static void main(String[] args) {
//        String s = "1234o World";
//        String substring = s.substring(0, 4);
//        System.out.println(substring);
//        System.out.println(s);
//        try {
//            int i = Integer.parseInt(substring);
//            System.out.println("454564545");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Hello World");
        String str = null;
        ArrayList<Integer> yearNum = getYearNum(str);
        for (int i = 0; i < yearNum.size(); i++) {
            String s = yearNum.get(i).toString();
            System.out.print(s + " ");
        }

    }

    public static ArrayList<Integer> getYearNum(String str){
        ArrayList<Integer> list = new ArrayList<>();
        if(str == null){
            return list;
        }
        int len = str.length();

        for (int i = 0; i < len - 4; i++) {
            String substring = str.substring(i, i + 4);
            boolean flag = false;
            Integer value = null;
            try {
                value = Integer.parseInt(substring);
                flag = true;
            }catch (Exception e){

            }
            if(flag && value >=1000 && value <= 3999){
                list.add(value);
            }

        }
        return list;
    }
}
