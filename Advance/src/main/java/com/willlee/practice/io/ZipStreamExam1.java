package com.willlee.practice.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamExam1 {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("src/main/resources/input.txt"));
            ZipOutputStream zipOutputStream = new ZipOutputStream(
                    new BufferedOutputStream(new FileOutputStream("src/main/resources/output.zip")));
            byte[] buf = new byte[1024];
            int len = 0;
            ZipEntry ze = new ZipEntry("input.txt");
            zipOutputStream.putNextEntry(ze);
            while ((len = bufferedInputStream.read(buf)) != -1) {
                zipOutputStream.write(buf, 0, len);
            }
            zipOutputStream.flush();
            zipOutputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
