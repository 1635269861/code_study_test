package com.bjpowernode.designmodel.build;

import java.security.PublicKey;

/**
 * @李永琪
 * @create 2020-10-02 18:38
 */
public class Hibuilder  extends HouseBuilder{
    @Override
    public void buildBasic() {
        System.out.println("高楼盖地基");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼盖墙体");
    }

    @Override
    public void roofed() {
        System.out.println("高楼盖屋顶");
    }

    @Override
    public void method() {

    }
}
