package com.willlee.leetcode.array;

//leetcode41
public class FirstMissingPositive {
    // 做法也是把1-n之间的数分别放在0-(n-1)的位置上去。
    // 但是这里数的范围并不是1到数组长度，需要把所有大于数组长度的数所在位置值边为-1。
    // 意义是把这样的数在数组中抹去。这样会影响到最后的结果吗？？？不会！！！
    // 因为缺失的正数一定是小于等于数组长度的数！！！
    // 假如说缺失的数不是小于数组的长度，那么数组中数的数量为该缺失的数-1，否则的话缺失的数是1到这个数之间的一个数而不是这个数。
    public static int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        // 将大于数组长度或者小于等于0的数字全部置成-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length)
                min = Math.min(nums[i], min);
            else
                nums[i] = -1;
        }
        if (min != 1)
            return 1;

        for (int i = 0; i < nums.length;) {
            int loc = nums[i];
            if (loc == -1 || loc - 1 == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[loc - 1]) {
                nums[i] = -1;
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[loc - 1];
            nums[loc - 1] = temp;
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 0)
                return i + 1;
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] a = { 3, 4, -1, 1 };
        int firstMissingPositive = firstMissingPositive(a);
        System.out.println(firstMissingPositive);
    }
}
