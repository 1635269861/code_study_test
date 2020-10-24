package com.bjpowernode.nio;

import com.sun.org.glassfish.external.arc.Stability;
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
 * @create 2020-10-03 15:13
 */
public class TestBlockingNio {

    //客户端
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ);
        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3.边读边写
        while (inChannel.read(buf) != -1){
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("10.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //2.绑定链接
        ssChannel.bind(new InetSocketAddress(9898));

        //3.获取客户端连接的通道
        SocketChannel channel = ssChannel.accept();
        //4.分配指定大小的缓存区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //5.接收客户端的数据并保存到本地
        while (channel.read(buf) != -1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        ssChannel.close();
        outChannel.close();
        channel.close();
    }

}
