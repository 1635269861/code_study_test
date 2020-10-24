package yingtailai;


import java.util.ArrayList;

/**
 * @李永琪
 * @create 2020-10-10 12:56
 */
public class Test4 {

    public static void main(String[] args) {
        ArrayList<Integer> list = getIndexOfNumber(4, 0);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i == list.size() - 1){
                stringBuilder.append(list.get(i));
            }else{
                stringBuilder.append(list.get(i) + " ");
            }
        }
        System.out.println(stringBuilder);
    }

    /**
     * 思路：模拟长除法的整个过程
     * 1.mod = a % b;
     * 2.小数 = (mod * 10) / b;
     * 3.mod = (mod * 10) % b;
     * 一直循环2、3步，当出现重复余数的时候就是循环出现了
     * @param num1
     * @param num2
     * @return
     */
    public static ArrayList<Integer> getIndexOfNumber(int num1, int num2) {
        if(num2 == 0){
            throw new RuntimeException("除数不能为0");
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int mod = num1 % num2;
        if(mod == 0){
            return new ArrayList<Integer>();
        }
        boolean flag = false;
        while (true){
            int temp = mod;
            mod = (temp * 10) / num2;
            if(list.size() > 0){
                for (int i = 0; i < list.size(); i++) {
                    if(mod == list.get(i)){
                        flag = true;
                        result.add(i);//开始位置
                        int len = list.size()  - i;
                        result.add(len);//长度位置
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
            list.add(mod);
            mod = (temp * 10) % num2;
            if(mod == 0){
                break;
            }
        }
        ArrayList<Integer> resul = new ArrayList<>();
        if(flag){
            resul.addAll(result);
        }else{
            resul.add(list.size());
            resul.add(0);
        }
        return resul;
    }

}
