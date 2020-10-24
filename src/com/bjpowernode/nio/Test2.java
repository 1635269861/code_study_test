package com.bjpowernode.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @李永琪
 * @create 2020-09-30 11:10
 */
public class Test2 {
    //使用直接缓存区完成文件的复制
    public static void main(String[] args) throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("G:\\09-[码家学院资料]JAVANIO\\nio.png"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("G:\\09-[码家学院资料]JAVANIO\\nio2.png"), StandardOpenOption.READ,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //映射文件
        MappedByteBuffer inMapperBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓存区中的数据进行读取写
        byte[] bytes = new byte[inMapperBuffer.limit()];
        inMapperBuffer.get(bytes);
        outBuffer.put(bytes);
        outChannel.close();
        inChannel.close();
        System.out.println("复制完毕");

    }

}
