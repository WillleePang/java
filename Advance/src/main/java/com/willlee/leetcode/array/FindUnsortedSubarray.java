package com.willlee.leetcode.array;

//leetcode581
public class FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int high = 0;// 第一个大值不正确的索引
        int low = 1; // 第一个小值不正确的索引
        int maxValue = Integer.MAX_VALUE;// 记录从左到右的当前最大值
        int minValue = Integer.MIN_VALUE;// 记录从右到左的当前最小值
        // 使用max记录局部极大值，使用end标记这个局部最大值应该出现的位置，比如数组内部出现了一个比较大的数，怎么办呢？
        // 只要后面的数比它小，那么end就记录下来当前位置，直到出现比他大的数字，max值被替换，说明我们已经找到，这个局部
        // 极大值应该存放的位置，就这样持续遍历到尾，期间可能出现好几个局部极大值，那么end一定会越来越靠后，即它表示局部最大值
        // 组成的集合中最大的那个值应该存放的位置。
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxValue = nums[i];
            } else {
                if (nums[i] < maxValue) {
                    high = i;
                }
                maxValue = Math.max(maxValue, nums[i]);
            }
        }
        // 同理，从后往前查找，用min表示局部极小值，star标记局部极小值应该存放的正确位置，持续遍历整个数组，若期间出现
        // 好几个局部极小，star一定越来越靠前，即它表示局部极小值组成的集合中最小的那个值应该存放的位置。
        // 如此看来，我们发现一个极大的数放错位置了，他应该放在end之歌位置,同时，一个极小的数也错了，他应该在star位置，
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                minValue = nums[i];
            } else {
                if (nums[i] > minValue) {
                    low = i;
                }
                minValue = Math.min(minValue, nums[i]);
            }
        }
        // 那么，这个最短的子序列长度我们就知道了，它就是end-star+1；
        return high - low + 1;
    }

    public static void main(String[] args) {
        int[] n = new int[] { 2, 6, 4, 8, 10, 9, 15 };
        int findUnsortedSubarray = findUnsortedSubarray(n);
        System.out.println(findUnsortedSubarray);
    }
}
