package com.bjpowernode.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @李永琪
 * @create 2020-09-29 22:16
 */
public class BufferTestNIO {

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("position" + buf.position());
        System.out.println("capcity:" + buf.capacity());
        System.out.println("limit:" + buf.limit());

        String s = "MAJIAXUEYUAN";
        buf.put(s.getBytes());

        System.out.println("===================");
        buf.flip();
        System.out.println("position" + buf.position());
        System.out.println("capcity:" + buf.capacity());
        System.out.println("limit:" + buf.limit());
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println("获取到的值：" + new String(bytes,0,bytes.length));
    }

}
