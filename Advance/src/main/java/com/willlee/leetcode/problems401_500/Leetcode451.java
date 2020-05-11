package com.willlee.leetcode.problems401_500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Leetcode451 {
    public String frequencySort(String s) {
        int[] charArray = new int[123];
        for (char c : s.toCharArray()) {
            charArray[(int) c]++;
        }
        PriorityQueue<Item> queue = new PriorityQueue<>((Item o1, Item o2) -> o2.getCount() - o1.getCount());
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 0) {
                queue.add(new Item((char) i, charArray[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            Item item = queue.poll();
            for (int i = 0; i < item.getCount(); i++) {
                sb.append(item.getA());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode451 a = new Leetcode451();
        String frequencySort = a.frequencySort("Aabb");
        System.out.println(frequencySort);
    }

    public String frequencySort1(String s) {
        HashMap<Integer, String> map = new HashMap<>();

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                char ch = (char) i;

                String str = map.get(freq[i]);
                // 字符出现次数相同, 进行拼接
                if (str != null) {
                    String strNew = str.concat(build(ch, freq[i]));
                    map.put(freq[i], strNew);
                } else {
                    map.put(freq[i], build(ch, freq[i]));
                }
            }
        }

        Integer[] keys = map.keySet().toArray(new Integer[] {});
        Arrays.sort(keys);
        StringBuilder sbl = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sbl.append(map.get(keys[i]));
        }

        return sbl.toString();
    }

    private String build(char ch, int times) {
        String string = Character.toString(ch);
        StringBuilder res = new StringBuilder(string);
        int t = 1;
        while (t < times) {
            res.append(string);
            t++;
        }

        return res.toString();
    }

}

class Item {
    char a;
    int count;

    public Item(char a, int count) {
        super();
        this.a = a;
        this.count = count;
    }

    public char getA() {
        return a;
    }

    public int getCount() {
        return count;
    }
}
