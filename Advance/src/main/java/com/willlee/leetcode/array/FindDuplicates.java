package com.willlee.leetcode.array;

import java.util.ArrayList;
import java.util.List;

//leetcode442
//这个题关键是在于将元素变成索引
public class FindDuplicates {
    // 输入输出的空间不属于额外空间，可以在输入数组中用数字的正负来表示该位置所对应数字是否已经出现过。
    // 遍历输入数组，给对应位置的数字取相反数，如果已经是负数，说明前面已经出现过，直接放入输出数组。
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                list.add(num);
            }
        }
        return list;
    }
}
