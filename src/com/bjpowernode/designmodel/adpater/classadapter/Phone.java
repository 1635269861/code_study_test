package com.bjpowernode.designmodel.adpater.classadapter;

/**
 * @李永琪
 * @create 2020-10-23 10:50
 */
public class Phone {

    //手机进行充电，看看是否能够进行适配
    public void charging(Vilotage5V vilotage5V){
        int res = vilotage5V.output5V();
        if(res == 5){
            System.out.println("输出电压魏5V，可以进行充电");
        }else{
            System.out.println("输出电压不是5V不能进行充电");
        }
    }

}
