package com.willlee.leetcode.problems801_900;

public class Leetcode880 {
    public static void main(String[] args) {
        Leetcode880 a = new Leetcode880();
        String decodeAtIndex = a.decodeAtIndex1("ab3", 6);
        System.out.println(decodeAtIndex);
    }

    public String decodeAtIndex1(String S, int K) {
        long size = 0;
        int N = S.length();
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }
        return null;
    }

    public String decodeAtIndex(String S, int K) {
        int i, count, lastCount;
        count = 0;
        lastCount = 0;
        for (i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                count *= S.charAt(i) - '0';
                if (count >= K)
                    return decodeAtIndex(S, (K - 1) % lastCount + 1); // 当整除的时候是找最后一个(lastCount)而不是0
            } else {
                count++;
                lastCount = count;
                if (count == K)
                    return "" + S.charAt(i);
            }
        }
        return null;
    }
}
