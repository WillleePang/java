package com.willlee.leetcode.problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//leetcode18
public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int l = j + 1, r = nums.length - 1, sum = target - nums[j] - nums[i];
                        while (l < r) {
                            if (nums[l] + nums[r] == sum) {
                                ls.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                l++;
                                r--;
                            } else if (nums[l] + nums[r] < sum) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                l++;
                            } else {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return ls;
    }
}
