package com.bjpowernode.designmodel.proto.DeepClone;

import java.io.*;

/**
 * @李永琪
 * @create 2020-10-03 11:57
 */
public class DeepProtoType implements Serializable,Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;

    //使用clone方法完成深拷贝
    @Override
    protected DeepProtoType clone() throws CloneNotSupportedException {
        DeepProtoType deepProtoType = (DeepProtoType) super.clone();
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //使用序列化完成深拷贝
    public DeepProtoType deepClone(){
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        DeepProtoType copyObj = null;

        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            copyObj = (DeepProtoType) ois.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                bos.close();
                bis.close();
                oos.close();
                ois.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return copyObj;
    }
}
