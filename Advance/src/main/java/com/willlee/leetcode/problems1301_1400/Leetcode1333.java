package com.willlee.leetcode.problems1301_1400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<int[]>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0)
                continue;
            if (restaurant[3] > maxPrice)
                continue;
            if (restaurant[4] > maxDistance)
                continue;
            list.add(restaurant);
        }
        Collections.sort(list, (int[] o1, int[] o2) -> {
            if (o1[1] != o2[1])
                return o2[1] - o1[1];
            else
                return o2[0] - o1[0];
        });
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] js = list.get(i);
            ret.add(js[0]);
        }
        return ret;
    }
}
