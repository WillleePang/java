package com.willlee.leetcode.problems801_900;

public class Leetcode825 {
    public int numFriendRequests(int[] ages) {
        // 统计每个年龄段的人数
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int result = 0;
        for (int i = 0; i <= 120; i++) {
            // 年龄段人数为0
            if (count[i] == 0)
                continue;
            // 同龄人
            if (i > 14) {
                result += count[i] * (count[i] - 1);
            }
            // 不同年龄的人，假设当前人为A，分析三个条件可知，另一个人B的年龄：
            // 1. ageB > 0.5 * ageA + 7
            // 2. 要小于A（等于的情况计算过了）
            // 3. 可以划入2
            // 这里在循环条件中控制了1，内层判断2.对于满足条件的，每个i可以给所有j发，所以是count[i] * count[j]
            for (int j = 0; j < i; j++) {
                if (j > (i >>> 1) + 7) {
                    result += count[i] * count[j];
                }
            }
        }
        return result;
    }
}
