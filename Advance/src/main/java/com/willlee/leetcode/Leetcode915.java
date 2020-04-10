package com.willlee.leetcode;

public class Leetcode915 {
    
    public int partitionDisjoint(int[] A) {
        int tmp = A[0], max = A[0], pos = 0;
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (A[i] < tmp) {
                pos = i;
                tmp = max;
            }
        }
        return pos + 1;
    }

    public static void main(String[] args) {
        int[] S = new int[] { 3, 6, 9, 0, 1, 4, 11, 10, 13 };
        Leetcode915 leetcode915 = new Leetcode915();
        int partitionDisjoint = leetcode915.partitionDisjoint(S);
        System.out.println(partitionDisjoint);
    }
}
