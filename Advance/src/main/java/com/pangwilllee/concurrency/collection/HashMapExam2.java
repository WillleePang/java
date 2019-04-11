package com.pangwilllee.concurrency.collection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashMapExam2 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>(10);
        System.out.println("map initialize");
        showMap(map);
        for (int i = 0; i < 20; i++) {
            map.put(i, new String(new char[] { (char) ('A' + i) }));
            System.out.println("put " + i);
            showMap(map);
        }
    }

    private static void showMap(Map<Integer, String> map) {
        try {
            Field f = HashMap.class.getDeclaredField("table");
            f.setAccessible(true);
            @SuppressWarnings("unchecked")
            Map.Entry<Integer, String>[] table = (Map.Entry<Integer, String>[]) f.get(map);
            f = HashMap.class.getDeclaredField("threshold");
            f.setAccessible(true);
            int threshold = (Integer) f.get(map);
            System.out.println("map size = " + map.size() + ",threshold = " + threshold + ",table:" + table);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
