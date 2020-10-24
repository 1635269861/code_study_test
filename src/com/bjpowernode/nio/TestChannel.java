package com.bjpowernode.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @李永琪
 * @create 2020-10-03 13:36
 */
public class TestChannel {

    //获取通道的三种方式
    //利用通道完成通道的复制
    @Test
    public void test1() throws Exception {
        //利用非直接缓冲区完成文件的复制
        FileInputStream fis = new FileInputStream("E:\\工作个人\\简历信息及相关荣誉证明-李永琪\\1.jpg");
        FileOutputStream fos = new FileOutputStream("2.jpg");
        //1.获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //2.创建缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //3.将数据写入到缓冲区
        while (inChannel.read(buf) != -1){
            //切换到读取模式
            buf.flip();
            //4.将数据写入到输出通道
            outChannel.write(buf);
            buf.clear();
        }
        System.out.println("文件复制完成");
        //关闭资源
        inChannel.close();
        outChannel.close();
        fis.close();
        fos.close();
    }

    //2.使用直接缓冲区完成文件的复制,采用内存映射文件的方式
    @Test
    public void test2() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);
        System.out.println(inChannel.size());
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //使用缓冲直接进行操作
        byte[] bytes = new byte[inMappedBuf.limit()];
        inMappedBuf.get(bytes);
        outMappedBuf.put(bytes);

        inChannel.close();
        outChannel.close();
        System.out.println("复制完成");
    }

    //通道之间的数据传输（直接缓存区）
    @Test
    public void test3() throws Exception{
        FileChannel inChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("5.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    //分散读取，聚集写入
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
        FileChannel channel = raf1.getChannel();
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024 * 12);
        ByteBuffer[] bufs = {buf1,buf2};

        //分散读取
        channel.read(bufs);

        //切换到读取模式
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
//        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
//        System.out.println("************************");
//        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));
        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel1 = raf2.getChannel();
        channel1.write(bufs);

        channel.close();
        channel1.close();
    }

    //字符集编码与解码
    //支持的字符集的种类
    @Test
    public void test5(){
        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();
        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

    //字符集转换
    @Test
    public void test6() throws CharacterCodingException {
        //使用GBK编码，使用GBK解吗
        Charset cs1 = Charset.forName("GBK");
        //编码器
        CharsetEncoder encoder = cs1.newEncoder();
        //解码器
        CharsetDecoder decoder = cs1.newDecoder();

        String str = "尚硅谷威武！";
        CharBuffer buf = CharBuffer.allocate(1024);
        buf.put(str);
        buf.flip();
        ByteBuffer byteBuffer = encoder.encode(buf);
        for (int i = 0; i < 12; i++) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.flip();
        CharBuffer buffer = decoder.decode(byteBuffer);
        System.out.println(buffer);

        System.out.println("-------------------------");
        //使用UTF-8进行解析
        byteBuffer.flip();
        Charset cs2 = Charset.forName("UTF-8");
        CharBuffer charBuffer = cs2.decode(byteBuffer);
        System.out.println(charBuffer);
    }

}
