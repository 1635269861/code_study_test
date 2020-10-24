package com.bjpowernode.designmodel.build;

/**
 * @李永琪
 * @create 2020-10-02 18:52
 */
public class Client {

    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        houseDirector.constructHouse();

        System.out.println("-------------------------");
        Hibuilder hibuilder = new Hibuilder();
        HouseDirector houseDirector1 = new HouseDirector(hibuilder);
        houseDirector1.constructHouse();

    }

}
