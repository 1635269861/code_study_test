package com.bjpowernode;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.lang.instrument.Instrumentation;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @李永琪
 * @create 2020-10-08 15:23
 */
public class Test2 {

    public static void main(String[] args) {
        byte[] bytes = new byte[1024*1024];
    }

    @Test
    public void test1(){
        new Thread();
    }

    @Test
    public void test2(){
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        hashSet.add(4);
        treeSet.add(4);

        hashSet.add(5);
        treeSet.add(5);

        hashSet.add(6);
        treeSet.add(6);

        hashSet.add(10);
        treeSet.add(10);

        hashSet.add(0);
        treeSet.add(0);

        hashSet.add(-1);
        treeSet.add(-1);

        System.out.println(hashSet);
        System.out.println(treeSet);

    }

    @Test
    public void test3(){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        linkedHashSet.add(1);
        Thread.interrupted();

        String string = new String();
    }


}
