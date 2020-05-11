package com.willlee.leetcode.problems1_100;

//leetcode33
public class Leetcode33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) // 有序数组使用正常的二分查找
                return binarySearch(nums, l, r, target);
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[l]) { // mid 在前一段
                if (nums[mid] < target)
                    l = mid + 1;
                else if (nums[l] > target)
                    l = mid + 1;
                else
                    r = mid - 1;
            } else { // mid 在后一段
                if (nums[mid] > target)
                    r = mid - 1;
                else if (nums[r] < target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return r >= 0 && nums[r] == target ? r : -1;
    }

    // 正常的二分查找
    private int binarySearch(int[] nums, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return r >= 0 && nums[r] == target ? r : -1;
    }
}
