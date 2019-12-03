package com.thinking.demo.chapter18;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ???
 *
 * @author Alphonse
 * @date 2019/11/27 08:52
 * @since 1.0
 **/
public class T2 {
    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel(); // stream->getChannel，相当于句柄
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        ByteBuffer buff = ByteBuffer.allocate(1024);
        //fc.read(buff);
        //buff.flip(); // 注意flip的作用
        buff.asIntBuffer().put(0x0f);
        buff.order(ByteOrder.LITTLE_ENDIAN);
        //buff.order(ByteOrder.BIG_ENDIAN);
        System.out.println(buff.getInt());

        /**
         * 使用Zip格式的文件，则需要自己显式声明在该压缩包中创建的文件实体entry，
         * 如果使用GZIP则不用显式声明，在压缩包中自动创建一个与压缩包名称一致的文件
         */

        FileOutputStream f = new FileOutputStream("C:\\Users\\DELL\\Desktop\\zz\\test1.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        zos.putNextEntry(new ZipEntry("name.txt"));
        zos.putNextEntry(new ZipEntry("io.txt"));
        BufferedOutputStream out = new BufferedOutputStream(zos); //zip可以保存多个文件
        BufferedOutputStream out2 = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\zz\\test.gz"))); //GZIP压缩格式
        String s = "You worked me hard.";
        zos.write(s.getBytes(), 0, s.getBytes().length);
        zos.setComment("comment: 0");
        out.close();

    }
}
