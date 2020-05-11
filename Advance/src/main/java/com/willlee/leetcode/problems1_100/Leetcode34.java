package com.willlee.leetcode.problems1_100;

//leetcode34
public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0) {
            return result;
        }
        int one = findFirst(nums, target);
        int two = findLast(nums, target);
        if (one != -1 && two != -1) {
            result[0] = one;
            result[1] = two;
            return result;
        }
        return result;
    }

    public int findFirst(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] > num) {
                // 正常的二分操作，中间值大于预期值，则在前半段继续进行查找
                high = mid - 1;
            } else if (nums[mid] < num) {
                // 正常的二分操作，中间值小于预期值，则在后半段继续进行查找
                low = mid + 1;
            } else if (mid - 1 >= low && nums[mid - 1] == num) {
                // 如果中间值的前一个值仍然是与预期值相同，那么则进行前半段查找，为的就是找到第一个与预期值相同的下标
                high = mid - 1;
            } else {
                // 如果中间值恰好相同，而且前一个值又没有相同，那么此时的中间值就是第一个与预期值相同的值
                return mid;
            }
        }
        return -1;
    }

    public int findLast(int[] nums, int num) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >>> 1);
            if (nums[mid] > num) {
                high = mid - 1;
            } else if (nums[mid] < num) {
                low = mid + 1;
            } else if (mid + 1 <= high && nums[mid + 1] == num) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
