package boss;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @李永琪
 * @create 2020-10-15 20:09
 */
public class Test3 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        int[] ints = calculateStatistics(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] calculateStatistics (int[] dataArr) {
        int[] res = new int[4];
        // write code here
        if(dataArr == null || dataArr.length == 0){
            return res;
        }
        Arrays.sort(dataArr);
        int maxIndex = dataArr.length - 1;
        int minVal = dataArr[0];
        int maxVal = dataArr[maxIndex];

        int midVal;
        if(dataArr.length % 2 == 0){
            int index = dataArr.length / 2;
            midVal = (dataArr[index] + dataArr[index - 1]) / 2;
        }else{
            int index = dataArr.length / 2;
            midVal = dataArr[index];
        }

        double indexTemp = 0.9 * dataArr.length;
        int ceil = (int) Math.ceil(indexTemp);
        int numOfTp90 = dataArr[ceil - 1];

        res[0] = midVal;
        res[1] = minVal;
        res[2] = maxVal;
        res[3] = numOfTp90;
        return res;
    }

    @Test
    public void test1(){
        double res = 35.0 / 20.0;
        int ceil = (int) Math.ceil(res);
        System.out.println(ceil);
    }

    @Test
    public void test2(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("k1","v1");
    }

}
