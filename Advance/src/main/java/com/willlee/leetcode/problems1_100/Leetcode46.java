package com.willlee.leetcode.problems1_100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    public static void main(String[] args) {
        Leetcode46 a = new Leetcode46();
        a.permute(new int[] { 1, 2, 3 });
        a.permute1(new int[] { 1, 2, 3 });
    }

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        traceback(nums, new ArrayList<Integer>());
        return ans;
    }

    private void traceback(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int num : nums) {
            if (temp.contains(num)) {
                continue;
            }
            temp.add(num);
            traceback(nums, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        process(nums, res, 0);
        return res;
    }

    // 变量left表示到达了某一层。
    public void process(int[] nums, List<List<Integer>> res, int left) {
        if (left == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        for (int i = left; i < nums.length; i++) {
            // 把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(nums, i, left);
            process(nums, res, left + 1);
            swap(nums, i, left);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
