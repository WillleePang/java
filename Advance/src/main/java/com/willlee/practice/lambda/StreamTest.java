package com.willlee.practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class StreamTest {
    public static void main(String[] args) {
        // 使用Stream.forEach()迭代
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(str -> System.out.println(str));

        stream = Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length() == 3).forEach(str -> System.out.println(str));

        stream = Stream.of("I", "love", "you", "too", "too");
        stream.distinct().forEach(str -> System.out.println(str));

        stream = Stream.of("I", "love", "you", "too");
        stream.sorted((str1, str2) -> str1.length() - str2.length()).forEach(str -> System.out.println(str));

        stream = Stream.of("I", "love", "you", "too");
        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));

        Stream<List<Integer>> stream1 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5));
        stream1.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));

        // 找出最长的单词
        stream = Stream.of("I", "love", "you", "too");
        Optional<String> reduce = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        stream = Stream.of("I", "love", "you", "too");
        Optional<String> max = stream.max((s1, s2) -> s1.length() - s2.length());
        System.out.println(reduce + " " + max);

        // 求单词长度之和
        stream = Stream.of("I", "love", "you", "too");
        int length1 = stream.reduce(0, // 初始值 // (1)
                (sum, str) -> sum + str.length(), // 累加器 // (2)
                (a, b) -> a + b);// 部分和拼接器，并行执行时才会用到 // (3)
        stream = Stream.of("I", "love", "you", "too");
        int length2 = stream.mapToInt(str -> str.length()).sum();
        System.out.println(length1 + " " + length2);

        // 将Stream转换成容器或Map
        stream = Stream.of("I", "love", "you", "too");
        List<String> list1 = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式１
        List<String> list = stream.collect(Collectors.toList()); // (1)
        Set<String> set = stream.collect(Collectors.toSet()); // (2)
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length)); // (3)

        // 使用Collectors.joining()拼接字符串
        stream = Stream.of("I", "love", "you");
        String joined1 = stream.collect(Collectors.joining());// "Iloveyou"
        String joined2 = stream.collect(Collectors.joining(","));// "I,love,you"
        String joined3 = stream.collect(Collectors.joining(",", "{", "}"));// "{I,love,you}"

    }
}
