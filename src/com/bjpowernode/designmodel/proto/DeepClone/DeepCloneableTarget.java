package com.bjpowernode.designmodel.proto.DeepClone;

import java.io.Serializable;

/**
 * @李永琪
 * @create 2020-10-03 11:55
 */
public class DeepCloneableTarget implements Serializable,Cloneable {

    private static final long serialVersionUID = +6849794470754667710L;

    public DeepCloneableTarget() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
