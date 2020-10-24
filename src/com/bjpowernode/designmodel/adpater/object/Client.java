package com.bjpowernode.designmodel.adpater.object;

/**
 * @李永琪
 * @create 2020-10-23 16:38
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VilotageObjectAdapter(new Vilotage220V()));
        
    }

}
