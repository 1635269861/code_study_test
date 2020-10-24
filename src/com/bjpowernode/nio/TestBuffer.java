package com.bjpowernode.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @李永琪
 * @create 2020-10-03 13:06
 */
public class TestBuffer {

    /**
     * 测试nio的reset方法
     */
    @Test
    public void testReset(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "abcdef";
        buf.put(str.getBytes());
        buf.flip();

        System.out.println("第一次读取并标记");
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
        buf.mark();
        System.out.println(buf.position());

        System.out.println("第二次读取");
        buf.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));
        System.out.println(buf.position());

        System.out.println("恢复为原来的标记的位置：");
        buf.reset();
        System.out.println(buf.position());
    }

    /**
     * 测试nio类的基本方法
     */
    @Test
    public void test1(){
        String s = "abcdef";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(s.getBytes());
        System.out.println("--------------将字节数组写入buffer----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("------------------切换到读取的模式-----------------------------");
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,bytes.length);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());

        System.out.println("---------------------重新读取的方式----------------------------------");
        byteBuffer.rewind();
        byte[] bytes1 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes1);
        System.out.println(new String(bytes1));
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());
    }

    /**
     * 直接缓存区与非直接缓存区
     */
    @Test
    public void test3(){
        //分配直接缓存区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
    }


}
