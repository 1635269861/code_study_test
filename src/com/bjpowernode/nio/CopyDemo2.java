package com.bjpowernode.nio;

import com.sun.deploy.util.SyncAccess;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @李永琪
 * @create 2020-09-30 11:33
 */
public class CopyDemo2 {

    //使用直接缓存区复制问价
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\大二课程设计\\电力电子课程设计报告参考.docx"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\大二课程设计\\电力电子课程设计报告参考3.docx"), StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //得到映射文件
        MappedByteBuffer inMapBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓存区进行数据的读写操作
        byte[] bytes = new byte[inMapBuffer.limit()];
        inMapBuffer.get(bytes);
        outMapBuffer.put(bytes);
        outChannel.close();
        inChannel.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - start);
    }

}
