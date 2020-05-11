package com.willlee.practice.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamExam {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("src/main/resources/input.txt"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                    new FileOutputStream("src/main/resources/output.txt"));
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bufferedInputStream.read(buf)) != -1) {
                bufferedOutputStream.write(buf, 0, len);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
