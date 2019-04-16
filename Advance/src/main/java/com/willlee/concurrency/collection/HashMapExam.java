package com.willlee.concurrency.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HashMapExam {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>(16);
        for (int i = 0; i < 15; i++) {
            map.put(i, new String(new char[] { (char) ('A' + i) }));
        }

        System.out.println("======keySet=======");
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("======values=======");
        Collection<String> values = map.values();
        Iterator<String> stringIterator = values.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }

        System.out.println("======entrySet=======");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
        Random seedGenerator = new Random();
        int randomSeed = seedGenerator.nextInt() | 0x0100; // ensure nonzero
        System.out.println(randomSeed);
        randomLevel(randomSeed);
    }

    private static int randomLevel(int randomSeed) {
        int x = randomSeed;
        System.out.println(Integer.toBinaryString(x));
        x ^= x << 13;
        System.out.println(Integer.toBinaryString(x));
        x ^= x >>> 17;
        System.out.println(Integer.toBinaryString(x));
        randomSeed = x ^= x << 5;
        System.out.println(Integer.toBinaryString(randomSeed));

        if ((x & 0x80000001) != 0) // test highest and lowest bits
            return 0;
        int level = 1;
        while (((x >>>= 1) & 1) != 0)
            ++level;
        return level;
    }
}
