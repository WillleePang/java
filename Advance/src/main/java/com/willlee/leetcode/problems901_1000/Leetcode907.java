package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

import com.willlee.leetcode.utils.Pair;
//思路：每个元素的左边和右边界限多长，界限的条件是，当前元素在此区间为最小元素
//https://pic.leetcode-cn.com/2f59d73899312f0c53eafdc5fc71daa31e221036b8eaca7e897a30c57b44b648-clipboard.png
public class Leetcode907 {

    public static void main(String[] args) {
        Leetcode907 leetcode907 = new Leetcode907();
        int sumSubarrayMins = leetcode907.sumSubarrayMins(new int[] { 3, 1, 2, 4 });
        System.out.println("====" + sumSubarrayMins + "====");
    }

    public int sumSubarrayMins1(int[] A) {
        // 利用一个单调递增栈，栈中元素的左边已经定好
        // 当新进一个元素时，判断其与栈顶大小关系，若大于，就设置当前元素的左边为栈顶元素的下标，后入栈
        // 若小于，就设置栈顶元素的右边为当前元素的下标，再继续判断下一个栈顶元素关系。
        // 若循环结束，栈非空，则全部元素右边设置为length
        int[] s = new int[A.length];
        int top = -1;
        int res = 0;
        int yushu = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < A.length; i++) {
            while (top > -1 && A[s[top]] > A[i]) {
                int tmp = s[top--];
                if (top == -1)
                    res += (tmp + 1) * (i - tmp) * A[tmp];
                else
                    res += (tmp - s[top]) * (i - tmp) * A[tmp];
                if (res > Integer.MAX_VALUE / 2)
                    res %= yushu;
            }
            s[++top] = i;
        }
        while (top > -1) {
            int tmp = s[top--];
            if (top == -1)
                res += (tmp + 1) * (A.length - tmp) * A[tmp];
            else
                res += (tmp - s[top]) * (A.length - tmp) * A[tmp];
            if (res > Integer.MAX_VALUE / 2)
                res %= yushu;
        }
        return res;
    }

    public int sumSubarrayMins(int[] A) {
        int MOD = 1000000007;
        Stack<Pair> stack = new Stack<Pair>();
        int ans = 0, tmp = 0;
        // 循环将A[i]放入stack中
        for (int i = 0; i < A.length; i++) {
            int count = 1;// 放入stack中，默认的次数是本身，也就是1
            // 如果stack本身不为空的话，而且栈顶元素值大于即将放入的值
            while (!stack.empty() && stack.peek().val >= A[i]) {
                // 栈顶元素出栈
                Pair pop = stack.pop();
                count += pop.count;
                tmp = tmp - pop.val * pop.count;
            }
            // 新的栈顶元素入栈
            stack.push(new Pair(A[i], count));
            tmp += A[i] * count;
            ans += tmp;
            System.out.println(tmp + " " + ans);
            ans %= MOD;
        }
        return ans;
    }

}
