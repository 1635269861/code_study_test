package boss;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-15 19:40
 */
public class Test1 {

    public static void main(String[] args) {
        String[] str1 = {"192.168.1.1","192.168.1.2","192.168.1.3"};
        String[] str2 = {"192.168.1.3","192.168.1.4"};
        boolean[] blackIp = isBlackIp(str1, str2);
        System.out.println(Arrays.toString(blackIp));
    }

    public static boolean[] isBlackIp (String[] ipArr, String[] blackIpArr) {
        // write code here
        if(ipArr == null || ipArr.length == 0){
            return null;
        }

        boolean[] res = new boolean[ipArr.length];
        HashSet<String> set = new HashSet<>();
        for (String s : blackIpArr) {
            set.add(s);
        }

        for (int i = 0; i < ipArr.length; i++) {
            if(set.contains(ipArr[i])){
                res[i] = true;
            }else{
                res[i] = false;
            }
        }

        return res;
    }

}
