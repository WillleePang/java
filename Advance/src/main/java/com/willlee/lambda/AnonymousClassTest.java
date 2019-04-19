package com.willlee.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassTest {
    public static void main(String[] args) {
        // 无参函数的简写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running!");
            }
        }).start();

        new Thread(() -> System.out.println("Thread running!")).start();

        new Thread(() -> {
            System.out.println("Thread running!");
            System.out.println("hello!");
        }).start();
        // 带参数函数的简写
        List<String> list = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1 == null)
                    return -1;
                if (s2 == null)
                    return 1;
                return s1.length() - s2.length();
            }
        });
        Collections.sort(list, (s1, s2) -> {
            if (s1 == null)
                return -1;
            if (s2 == null)
                return 1;
            return s1.length() - s2.length();
        });
    }
}
