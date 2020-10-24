package com.bjpowernode.designmodel.build;

import java.security.PublicKey;

/**
 * @李永琪
 * @create 2020-10-02 18:37
 */
public class CommonHouse extends HouseBuilder{


    @Override
    public void buildBasic() {
        System.out.println("普通房子盖地基");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子盖墙体");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子盖屋顶");
    }

    @Override
    public void method() {

    }
}
