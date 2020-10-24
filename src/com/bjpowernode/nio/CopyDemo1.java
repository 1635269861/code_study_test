package com.bjpowernode.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @李永琪
 * @create 2020-09-30 11:24
 */
public class CopyDemo1 {

    //使用间接缓存完成文件的复制
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\大二课程设计\\电力电子课程设计报告参考.docx");
        FileOutputStream fos = new FileOutputStream("E:\\大二课程设计\\电力电子课程设计报告参考2.docx");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannle = fos.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf) != -1){
            buf.flip();//切换到读取模式
            outChannle.write(buf);
            buf.clear();
        }

        //关闭连接
        outChannle.close();
        inChannel.close();
        fos.close();
        fis.close();
        System.out.println("使用非直接缓存区复制需要花费的时间是:" + (System.currentTimeMillis() - start));


    }

}
