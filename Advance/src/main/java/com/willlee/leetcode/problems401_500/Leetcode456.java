package com.willlee.leetcode.problems401_500;

import java.util.Stack;

public class Leetcode456 {
    public static void main(String[] args) {
        Leetcode456 a = new Leetcode456();
        boolean find132pattern = a.find132pattern3(new int[] { 6, 12, 3, 4, 6, 11, 20 });
        System.out.println(find132pattern);
    }

    public boolean find132pattern3(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;
        int last = Integer.MIN_VALUE; // 132中的2
        int[] stk = new int[n];
        int top = -1;// 用来存储132中的3
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < last) // 若出现132中的1则返回正确值
                return true;
            while (top > -1 && stk[top] < nums[i]) { // 单调递减栈
                last = stk[top];
                top--;
            }
            // 弹完之后，last更新为在以nums[i]为最大值的[i,~]区间内的次大值
            // 若下一个nums[i]<last，则说明找到了132
            stk[++top] = nums[i];
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        // 栈中保存的是最大值
        Stack<Integer> stack = new Stack<>();
        // second为第二大的值
        int second = Integer.MIN_VALUE;
        stack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            // 如果有比second小的数出现，说明符合要求，返回true
            if (nums[i] < second) {
                return true;
            } else {
                // 否则，说明当前的值比第二的大，也就是当前值是最大值。
                // 应该把当前值放到栈中，但是在这之前要更新second，把比当前值小的最大值（第二大的值）给second
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = Math.max(second, stack.pop());
                }
                stack.push(nums[i]);
            }
        }
        // 遍历整个数组，也没有发现当前值小于第二大的值，返回false
        return false;
    }

    public boolean find132pattern1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) { // 从后往前遍历nums数组中的元素
            if (nums[i] > min[i]) {
                // 找到了ai = min[j]和aj = nums[j]，现在需要在[j+1,n-1]范围内寻找ak使得ai<ak<aj
                // 如果栈顶元素小于等于min[j]的，将栈顶元素出栈，这样就保证了ak > ai
                // 那么已弹出栈的元素是否可能会被漏过呢？
                // 不会的，因为我们从后往前遍历nums数组中的元素，min数组的值会越来越大，那些已经出栈的元素更加不可能大于当前的min[j]，即a[i]
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) { // 判断栈顶元素是否满足ak<aj
                    return true;
                }
                stack.push(nums[i]); // 保证了栈中的元素肯定是在[j+1,n-1]范围内的，即我们在栈中寻找ak
            }
        }
        return false;
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int n = nums.length;
        int l = 0;
        int r = 1;
        while (l < n - 1) {
            r = l + 1;
            while (l < r && r < n) {
                if (nums[l] < nums[r]) {
                    if (find(l, r, nums)) {
                        return true;
                    }
                }
                r++;
            }
            l++;
        }
        return false;
    }

    private boolean find(int l, int r, int[] a) {
        int m = r + 1;
        int n = a.length;
        if (a[m] < a[l])
            while (m < n) {
                if (a[l] < a[m] && a[m] < a[r]) {
                    return true;
                }
                m++;
            }
        return false;
    }
}
