package com.bjpowernode.niuke;

/**
 * @李永琪
 * @create 2020-09-20 23:22
 */
public class StrToInt {

    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        if(str.length() == 1 && (str.charAt(0) == 45 || str.charAt(0) == 45)){
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if(i == 0){
                if(str.charAt(i) == 45 || str.charAt(i) == 43 || (str.charAt(i) >= 48 && str.charAt(i) <= 57)){
                    continue;
                }else{
                    return 0;
                }
            }else{
                if(str.charAt(i) < 48 || str.charAt(i) > 57){
                    return 0;
                }
            }
        }
        int i = Integer.parseInt(str);
        return i;
    }
    
}
