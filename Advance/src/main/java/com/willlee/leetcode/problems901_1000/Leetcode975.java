package com.willlee.leetcode.problems901_1000;

import java.util.Map;
import java.util.TreeMap;

public class Leetcode975 {

    public static void main(String[] args) {
        Leetcode975 a = new Leetcode975();
        a.oddEvenJumps(new int[] { 5, 1, 3, 4, 2 });
    }

    public int oddEvenJumps(int[] A) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // 奇数跳 你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。
        boolean[] oddJump = new boolean[A.length];
        // 偶数跳 你将会跳到索引 j，使得 A[i] >= A[j]，A[j] 是可能的最大值
        boolean[] evenJump = new boolean[A.length];
        oddJump[A.length - 1] = evenJump[A.length - 1] = true;
        treeMap.put(A[A.length - 1], A.length - 1);
        int ans = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            Integer key = A[i];
            Map.Entry<Integer, Integer> evenEntry = treeMap.floorEntry(key);
            evenJump[i] = evenEntry != null && oddJump[evenEntry.getValue()];
            Map.Entry<Integer, Integer> oddEntry = treeMap.ceilingEntry(key);
            oddJump[i] = oddEntry != null && evenJump[oddEntry.getValue()];
            ans = oddJump[i] ? ans + 1 : ans;
            treeMap.put(key, i);
        }
        return ans;
    }

}
