package com.bjpowernode.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @李永琪
 * @create 2020-10-03 15:36
 */
public class TestBlockingNio2 {

    @Test
    public void test1() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf) != -1){
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
        socketChannel.shutdownOutput();

        //接收服务端的数据反馈

      int len = 0;
        while ((len = socketChannel.read(buf)) != -1){
            buf.flip();
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        inChannel.close();
        socketChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1.指定接收端口号
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("45.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //2.绑定端口号
        ServerSocketChannel socketChannel = ssChannel.bind(new InetSocketAddress(9898));

        //3.接收通道
        SocketChannel channel = socketChannel.accept();

        //4.建立指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //5.接收数据，边读边写
        while (channel.read(buf) != -1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //返回信息给客户端
        buf.put("服务端已经接收到数据".getBytes());
        buf.flip();
        channel.write(buf);

        //6.关闭资源
        ssChannel.close();
        socketChannel.close();
        outChannel.close();
    }
}
