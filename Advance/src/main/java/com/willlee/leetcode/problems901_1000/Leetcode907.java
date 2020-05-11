package com.willlee.leetcode.problems901_1000;

import java.util.Stack;

//https://pic.leetcode-cn.com/2f59d73899312f0c53eafdc5fc71daa31e221036b8eaca7e897a30c57b44b648-clipboard.png
public class Leetcode907 {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1000000007;
        Stack<Pair1> stack = new Stack<Pair1>();
        int ans = 0, tmp = 0;
        // 循环将A[i]放入stack中
        for (int i = 0; i < A.length; i++) {
            int count = 1;// 放入stack中，默认的次数是本身，也就是1
            // 如果stack本身不为空的话，而且栈顶元素值大于即将放入的值
            while (!stack.empty() && stack.peek().val >= A[i]) {
                // 栈顶元素出栈
                Pair1 pop = stack.pop();
                count += pop.count;
                tmp = tmp - pop.val * pop.count;
            }
            // 新的栈顶元素入栈
            stack.push(new Pair1(A[i], count));
            tmp += A[i] * count;
            ans += tmp;
            System.out.println(tmp + " " + ans);
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode907 leetcode907 = new Leetcode907();
        int sumSubarrayMins = leetcode907.sumSubarrayMins(new int[] { 3, 1, 2, 4 });
        System.out.println("====" + sumSubarrayMins + "====");
    }
}

class Pair1 {
    public int val;
    public int count;

    public Pair1(int val, int count) {
        this.val = val;
        this.count = count;
    }
}
