package com.bjpowernode.nio;


import java.nio.ByteBuffer;

/**
 * @李永琪
 * @create 2020-09-30 10:41
 */
public class BufferTest2 {

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String s = "MAJIAXUEYUAN";

        System.out.println("读取之前：");
        System.out.println("position:" + buf.position());
        System.out.println("limit:" + buf.limit());
        System.out.println("capacity:" + buf.capacity());

        System.out.println("读取之后：");
        buf.put(s.getBytes());
        buf.flip();
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println("position:" + buf.position());
        System.out.println("limit:" + buf.limit());
        System.out.println("capacity:" + buf.capacity());

        buf.mark();
        buf.get(bytes,2,2);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println("position:" + buf.position());
        System.out.println("limit:" + buf.limit());
        System.out.println("capacity:" + buf.capacity());

        buf.reset();
        System.out.println("position:" + buf.position());
        System.out.println("limit:" + buf.limit());
        System.out.println("capacity:" + buf.capacity());

    }

}
