package boss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @李永琪
 * @create 2020-10-15 19:47
 */
public class Test2 {

    public static void main(String[] args) {
        String str = "ope";
        String[] strs = {"hope","there"};
        ArrayList<String> list = filterSensitiveWords(str, strs);
        System.out.println(list);
    }

    public static ArrayList<String> filterSensitiveWords (String content, String[] sensitiveWords) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        if(content == null || content.length() == 0){
            return res;
        }

        HashSet<String> set = new HashSet<>();
        ArrayList<Integer> setOfLen = new ArrayList<>();
        for (String sensitiveWord : sensitiveWords) {
            set.add(sensitiveWord);
            setOfLen.add(sensitiveWord.length());
        }
        Collections.sort(setOfLen);

        int min = setOfLen.get(0);
        if(min > content.length()){
            return res;
        }
        for (int i = 0; i < content.length() - min + 1; i++) {
            for (Integer integer : setOfLen) {
                try {
                    String substring = content.substring(i, i + integer);
                    if(set.contains(substring)){
                        res.add(substring);
                    }
                }catch (Exception e){
                    continue;
                }
            }
        }

        return res;
    }


    @Test
    public void test1(){
        String s = "4646516122256346";
        String substring = s.substring(1, 1 + 1);
        System.out.println(substring);
    }

}
