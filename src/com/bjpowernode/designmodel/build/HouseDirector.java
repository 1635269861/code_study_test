package com.bjpowernode.designmodel.build;

/**
 * @李永琪
 * @create 2020-10-02 18:50
 */
public class HouseDirector {

    public HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
    }
}
