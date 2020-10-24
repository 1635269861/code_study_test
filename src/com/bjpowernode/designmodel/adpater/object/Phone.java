package com.bjpowernode.designmodel.adpater.object;

/**
 * @李永琪
 * @create 2020-10-23 16:36
 */
public class Phone {

    public void charging(VilotageObjectAdapter vilotageObjectAdapter){
        int res = vilotageObjectAdapter.output5V();
        if(res == 5){
            System.out.println("当前电压已经被转为5V");
        }else{
            System.out.println("当前电压过大，不能进行充电");
        }
    }

}
