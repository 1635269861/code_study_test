package com.bjpowernode.nio;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @李永琪
 * @create 2020-09-30 11:46
 */
public class OneToMore {

    //分散读取和聚集写入
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("E:\\大二课程设计\\电力电子课程设计报告参考.docx", "rw");
        //1.获取通道
        FileChannel channel = raf.getChannel();
        //2.分配指定大小的缓存区
        ByteBuffer buf1 = ByteBuffer.allocate(1204*1024*2);
        ByteBuffer buf2 = ByteBuffer.allocate(1204*1024*2);
        //3.分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel.read(bufs);
        for (ByteBuffer buf : bufs) {
            //切换为读取模式
            buf.flip();
        }
//        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
//        System.out.println("----------------");
//        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
        //4.聚集写入
        RandomAccessFile rw = new RandomAccessFile("E:\\大二课程设计\\电力电子课程设计报告参考5.docx", "rw");
        FileChannel channel1 = rw.getChannel();
        channel1.write(bufs);
        channel1.close();
        channel.close();
    }

}
