package com.willlee.leetcode.array;

//leetcode45
public class Jump {
    public static int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            // 循环i，再reach的范围之内找到下一次最大的步数
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1)
                return (step + 1);
            if (i == reach) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
