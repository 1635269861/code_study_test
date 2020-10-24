package yingtailai;

/**
 * @李永琪
 * @create 2020-10-10 12:41
 */
public class Test1 {

    public static void main(String[] args) {
        int fiBoNaQI = getFiBoNaQI(9);
        System.out.println(fiBoNaQI);
    }

    public static int getFiBoNaQI(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[arr.length - 1];
    }

}
