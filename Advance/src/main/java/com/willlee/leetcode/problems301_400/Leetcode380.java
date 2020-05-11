package com.willlee.leetcode.problems301_400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Leetcode380 {

}

// leetcode380
class RandomizedSet {
    private List<Integer> absentIndexs = new LinkedList<Integer>();
    private Map<Integer, Integer> kv = new HashMap<>();
    private Map<Integer, Integer> vk = new HashMap<>();
    private int maxIndex = 0;
    private Random random = new Random();

    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already
     * contain the specified element.
     */
    public boolean insert(int val) {
        if (vk.containsKey(val)) {
            return false;
        }
        Integer index = absentIndexs.isEmpty() ? null : absentIndexs.get(0);
        if (index != null) {
            absentIndexs.remove(0);
        } else {
            index = maxIndex;
            maxIndex++;
        }
        kv.put(index, val);
        vk.put(val, index);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the
     * specified element.
     */
    public boolean remove(int val) {
        if (!vk.containsKey(val)) {
            return false;
        }
        absentIndexs.add(0, vk.get(val));
        kv.remove(vk.get(val));
        vk.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        while (true) {
            int i = random.nextInt(maxIndex);
            if (kv.containsKey(i)) {
                return kv.get(i);
            }
        }
    }
}
