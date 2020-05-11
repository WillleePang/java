package com.willlee.leetcode.problems301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Leetcode381 {

}

// leetcode381
class RandomizedCollection {
    private Map<Integer, Set<Integer>> map;// 字典表

    private List<Integer> list;

    private Random random;

    private int size = 0;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        // 查看字典表中是否存在这个value
        if (map.containsKey(val)) {// 存在就更新索引，并将value添加到list中去
            Set<Integer> indexes = map.get(val);
            indexes.add(size);
            list.add(size, val);
            size++;
            return false;
        } else {// 不存在，就创建索引，并将value添加到list中去
            Set<Integer> indexes = new HashSet<>();
            map.put(val, indexes);
            indexes.add(size);
            list.add(size, val);
            size++;
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {// 是否存在字典表中
            return false;
        }
        Set<Integer> indexes = map.get(val);// 取出值的索引
        if (list.get(size - 1) == val) {// list的最后一个value是不是等于当前值，如果相等就直接删除索引的最后一个值
            indexes.remove(size - 1);
            size--;
        } else {
            // 将要删除的值的索引第一个删除
            Iterator<Integer> it = indexes.iterator();
            // 记录删除的索引值
            int index = it.next();
            it.remove();
            // 将最后一个元素，放到删除的元素位置
            int last = list.get(size - 1);
            // 更新最后一个元素的索引值
            list.set(index, last);
            Set<Integer> set = map.get(last);
            set.remove(size - 1);
            set.add(index);
            size--;
        }
        if (indexes.size() == 0) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}
