package com.bjpowernode.designmodel.proto;

import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @李永琪
 * @create 2020-10-03 11:24
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("tom", 12, "白色");
        sheep.setFriend(new Sheep("jack",1,"黑色"));
        Sheep sheep1 = sheep.clone();
        Sheep sheep2 = sheep.clone();
        Sheep sheep3 = sheep.clone();
        Sheep sheep4 = sheep.clone();

        //浅拷贝
        System.out.println(sheep + "  " + sheep.getFriend().hashCode());
        System.out.println(sheep1 + "  " + sheep.getFriend().hashCode());
        System.out.println(sheep2 + "  " + sheep.getFriend().hashCode());
        System.out.println(sheep3 + "  " + sheep.getFriend().hashCode());
        System.out.println(sheep4 + "  " + sheep.getFriend().hashCode());
    }

}
