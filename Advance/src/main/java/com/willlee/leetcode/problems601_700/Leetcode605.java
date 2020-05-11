package com.willlee.leetcode.problems601_700;

//leetcode605
public class Leetcode605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i - 1 == -1 || flowerbed[i - 1] == 0)
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
}
