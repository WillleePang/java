package com.willlee.leetcode.problems901_1000;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode950 {

    // 于是我们尝试着倒着看示例，我们有一个数组，数组中元素不重复，
    // 且按照降序排列，我们称之为卡牌，初始值为[17,13,11,7,5,3,2]，
    // 我们有另一个队列，初始为空，我们每次将数组中未放入队列中的最大的数插入到队列中，
    // 然后我们把队首元素移到队尾，重复这个过程，直到数组中所有元素都被放入队列中为止。

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList<Integer>();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode950 a = new Leetcode950();
        a.deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 });
    }
}
