package com.willlee.leetcode.problems1_100;

//leetcode42
public class Leetcode42 {
    // 一个简单的思路就是雨水容量等于平铺总面积减去柱子面积，那我们只需要求出柱子面积和，以及按照最高计算的平铺总面积就行
    public static int trap(int[] height) {
        int col = 0;
        int all = 0;
        int maxh = 0;
        for (int i = 0; i < height.length; i++) {
            col += height[i];
            maxh = Math.max(maxh, height[i]);
        }
        for (int i = 1; i <= maxh; i++) {
            int l = 0;
            int r = height.length - 1;
            while (l < r && height[l] < i) {
                l++;
            }
            while (l < r && height[r] < i) {
                r--;
            }
            all += (r - l + 1);
        }
        return all - col;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 2, 0, 2 };
        int trap = trap(a);
        System.err.println(trap);
    }
}
