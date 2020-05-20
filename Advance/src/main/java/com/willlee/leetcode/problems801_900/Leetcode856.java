package com.willlee.leetcode.problems801_900;

public class Leetcode856 {
    public static void main(String[] args) {
        Leetcode856 a = new Leetcode856();
        int scoreOfParentheses = a.scoreOfParentheses("(()(()))");
        System.out.println(scoreOfParentheses);
    }

    // 事实上，我们可以发现，只有 () 会对字符串 S 贡献实质的分数，其它的括号只会将分数乘二或者将分数累加。因此，我们可以找到每一个 ()
    // 对应的深度 x，那么答案就是 2^x 的累加和。
    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }
        return ans;
    }

}
