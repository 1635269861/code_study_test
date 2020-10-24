package com.bjpowernode.designmodel.adpater.classadapter;

/**
 * @李永琪
 * @create 2020-10-23 10:49
 */
//适配器类
public class VilotageAdapter extends Vilotage220V implements Vilotage5V {


    @Override
    public int output5V() {
        int srcV = output220V();
        int destV = srcV / 44;
        return destV;
    }
}
