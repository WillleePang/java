package com.willlee.nio;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatterAndGatherExample {
    private static RandomAccessFile file;
    private static FileInputStream fis;

    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        buffer1.put("hello".getBytes("GBK")).flip();
        ByteBuffer buffer2 = ByteBuffer.allocate(5);
        buffer2.put("world".getBytes("GBK")).flip();
        ByteBuffer[] buffers = { buffer1, buffer2 };

        try {
            file = new RandomAccessFile("src/main/resources/filelock.txt", "rw");
            FileChannel channel = file.getChannel();
            channel.write(buffers);
            channel.force(false);
            channel.close();

            showFileContent("src/main/resources/filelock.txt");

            // scatter example
            buffer1.clear();
            buffer2.clear();
            file = new RandomAccessFile("src/main/resources/filelock.txt", "r");
            channel = file.getChannel();
            channel.read(buffers);
            String str1 = getBufferContent(buffer1);
            String str2 = getBufferContent(buffer2);
            System.out.println("buffer1 :" + str1);
            System.out.println("buffer2 :" + str2);
            channel.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getBufferContent(ByteBuffer buffer) throws UnsupportedEncodingException {
        buffer.flip();
        System.out.println(buffer);
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        return new String(bytes, "GBK");
    }

    private static void showFileContent(String filepath) {
        try {
            fis = new FileInputStream(filepath);
            byte[] bytes = new byte[1024];
            int len = 0;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = fis.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            String str = baos.toString("GBK");
            System.out.println("file content:");
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
