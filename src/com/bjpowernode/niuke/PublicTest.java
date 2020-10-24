package com.bjpowernode.niuke;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @李永琪
 * @create 2020-10-06 18:58
 */
public class PublicTest {

    @Test
    public void test1(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
        Integer integer = queue.poll();
        System.out.println(integer);
        System.out.println(queue);
    }

    @Test
    public void test2(){
        String s = "woaini,zhongguo";
        String s1 = s.substring(0, 2);
        System.out.println(s);
    }

    @Test
    public void test3(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(9);
        Collections.sort(list);
        System.out.println(list);
    }

}
