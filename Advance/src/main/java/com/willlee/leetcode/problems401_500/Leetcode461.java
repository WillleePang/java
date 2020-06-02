package com.willlee.leetcode.problems401_500;

public class Leetcode461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if (z % 2 == 1) {
                count++;
            }
            z = z >> 1;
        }
        return count;
    }

    public int hammingDistance3(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            z &= (z - 1);
            count++;
        }
        return count;
    }
}
