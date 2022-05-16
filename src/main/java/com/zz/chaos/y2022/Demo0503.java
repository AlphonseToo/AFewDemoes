package com.zz.chaos.y2022;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class Demo0503 {

    public static void main(String[] args) throws Throwable {
        Selector selector = Selector.open();
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\Mine\\Desktop\\问题sql.sql", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        int read = fileChannel.read(byteBuffer);
        selector.select();
        while (read != -1) {
            // 切换到读模式
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println(byteBuffer.get());
            }
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        file.close();
    }
}
