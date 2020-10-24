package qunaer;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * @李永琪
 * @create 2020-10-14 19:13
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int options = getOptions(m, n);
        System.out.println(options);


    }

    //定义一个方法：得到挑选的选法的步骤
    public static int getOptions(int m, int n){
        if(m == 0 || n == 0 || n > m){
            return 0;
        }

        if(m == n){
            return 1;
        }

        int temp = n;

        int res1 = 1;
        while (temp != 0){
            res1 *= m;
            m--;
            temp--;
        }

        //获取阶乘
        int num = getResultOfNum(n);
        int result = res1 / num;
        return result;
    }

    //定义一个方法，计算一个数字的阶乘
    public static int getResultOfNum(int n){
        if(n == 1){
            return 1;
        }

        return n * getResultOfNum(n - 1);
    }

}
