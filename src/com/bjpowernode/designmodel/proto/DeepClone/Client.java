package com.bjpowernode.designmodel.proto.DeepClone;

/**
 * @李永琪
 * @create 2020-10-03 12:00
 */
public class Client {

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.name = "宋江";
        deepProtoType.deepCloneableTarget = new DeepCloneableTarget();

        //DeepProtoType deepProtoType1 = deepProtoType.clone();
        DeepProtoType deepProtoType1 = deepProtoType.deepClone();

        System.out.println(deepProtoType.name + "--->" + deepProtoType.hashCode());
        System.out.println(deepProtoType1.name + "--->" + deepProtoType1.hashCode());
    }

}
