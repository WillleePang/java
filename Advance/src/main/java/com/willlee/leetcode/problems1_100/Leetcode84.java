package com.willlee.leetcode.problems1_100;

import java.util.Stack;

//leetcode84
public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        /*
         * 已知每个柱体必然有恰好覆盖自身（矩形高度与柱体高度相等)的矩形。而最大值必然在这heights.length个矩形中产生
         * 这个矩形的面积即当前处理柱形的高度乘以左右边界差 将各个柱体依次压入栈 若将要入栈的柱体高度大于等于目前栈顶柱体的高度 则直接入栈
         * 若将要入栈的柱体高度小于栈顶柱体高度 说明将要入栈的柱体 即为 栈顶柱体对应最大矩形的右边界 而栈顶柱体的左边界即紧邻栈 顶的下一个矩形
         * 则栈顶柱体对应矩形面积可求 栈顶柱体处理完毕 出栈 再次检查将要入栈柱体与新栈顶的大小 重复上述步骤 直到将要入栈柱体可以入栈
         * 更新将要入栈的柱体 重复上述步骤 可能出现循环完之后栈中还有柱体存在的情况 这时可以继续用高度为0
         * 下标为heights.length的柱体入栈 直到栈中没有柱体 (对应最后一个while的作用)
         */
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int cur = stack.pop();
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, len * heights[cur]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int len = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            max = Math.max(max, len * heights[cur]);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        return maxArea(heights, 0, len - 1);
    }

    private int maxArea(int[] h, int left, int right) {
        if (left == right)
            return h[right];
        int min = left;
        boolean sorted = true;
        for (int i = left + 1; i <= right; i++) {
            if (h[i] < h[i - 1])
                sorted = false;
            if (h[i] < h[min])
                min = i;
        }
        if (sorted) {
            int max = 0;
            for (int i = left; i <= right; i++)
                max = Math.max(max, h[i] * (right - i + 1));
            return max;
        }
        int l = (min > left) ? maxArea(h, left, min - 1) : 0;
        int r = (min < right) ? maxArea(h, min + 1, right) : 0;
        return Math.max(Math.max(l, r), h[min] * (right - left + 1));
    }
}
