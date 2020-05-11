package com.willlee.practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                if (str.length() > 3)
                    System.out.println(str);
            }
        });
        list.forEach(str -> {
            if (str.length() > 3)
                System.out.println(str);
        });

        list.removeIf(new Predicate<String>() { // 删除长度大于3的元素
            @Override
            public boolean test(String str) {
                return str.length() > 3;
            }
        });
        list.removeIf(str -> str.length() > 3); // 删除长度大于3的元素

        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String str) {
                if (str.length() > 3)
                    return str.toUpperCase();
                return str;
            }
        });
        list.replaceAll(str -> {
            if (str.length() > 3)
                return str.toUpperCase();
            return str;
        });

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        list.sort((str1, str2) -> str1.length() - str2.length());

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer k, String v) {
                System.out.println(k + "=" + v);
            }
        });
        // 使用forEach()结合Lambda表达式迭代Map
        map.forEach((k, v) -> System.out.println(k + "=" + v));

        // Java8使用Map.getOrDefault()
        System.out.println(map.getOrDefault(4, "NoValue"));

        // 使用replaceAll()结合匿名内部类实现
        map.replaceAll(new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer k, String v) {
                return v.toUpperCase();
            }
        });

        // 使用replaceAll()结合Lambda表达式实现
        map.replaceAll((k, v) -> v.toUpperCase());

        Map<Integer, Set<String>> map1 = new HashMap<>();
        // Java8的实现方式
        map1.computeIfAbsent(1, v -> new HashSet<String>()).add("yi");
    }
}
