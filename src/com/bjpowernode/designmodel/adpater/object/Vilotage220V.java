package com.bjpowernode.designmodel.adpater.object;

/**
 * @李永琪
 * @create 2020-10-23 11:03
 */
public class Vilotage220V {

    public int output220V(){
        int returnVal = 550;
        System.out.println("被适配的电压为" + returnVal + "V");
        return returnVal;
    }

}
