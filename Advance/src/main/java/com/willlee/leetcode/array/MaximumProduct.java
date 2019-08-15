package com.willlee.leetcode.array;

//leetcode628
public class MaximumProduct {
    // 当数组长度为3，那么直接把三个数都取过来
    // 当数组长度大于等于4，而且至少存在一个正数，最大值一定为正数。（此时能够保证，剩下的个数里，至少存在两个负数或两个正数）
    // 要想结果为正数，我们最少要使用一个正数，那么最大的正数肯定要参与运算。然后要使得剩下的两个数的积最大，要么我们就取次大的两个数，要么就取最小的两个数）
    // 结合上面三个结论，我们只需要找到最大的三个数，和最小的两个数。将最大的三数之积与最小两个数和最大数之积作比较，取大然后返回就好了。

    /*
     * 当数组长度大于等于4时，数组排序后： a,b,...,c,d,e 最大值max(a*b*e,c*d*e)
     */

    public int maximumProduct(int[] nums) {
        int max1 = -1001, max2 = -1001, max3 = -1001;
        int min1 = 1001, min2 = 1001;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max2 * max3 * max1, min1 * min2 * max1);
    }
}
