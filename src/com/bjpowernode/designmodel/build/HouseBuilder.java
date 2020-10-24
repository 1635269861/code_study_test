package com.bjpowernode.designmodel.build;

/**
 * @李永琪
 * @create 2020-10-02 18:35
 */
public abstract class HouseBuilder {

    public House house = new House();

    public abstract void buildBasic();

    public abstract void buildWall();

    public abstract void roofed();

    public abstract void method();


}
