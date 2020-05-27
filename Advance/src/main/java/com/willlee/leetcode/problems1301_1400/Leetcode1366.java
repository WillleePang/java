package com.willlee.leetcode.problems1301_1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode1366 {
    public static void main(String[] args) {
        Leetcode1366 a = new Leetcode1366();
        a.rankTeams1(new String[] { "ABC", "ACB", "ABC", "ACB", "ACB" });
    }

    public String rankTeams(String[] votes) {
        if (votes.length == 1) {
            return votes[0];
        }
        int[][] rank = new int[26][votes[0].length()];
        for (String vote : votes) {
            for (int j = 0; j < vote.length(); j++) {
                rank[vote.charAt(j) - 'A'][j]++;
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < votes[0].length(); i++) {
            list.add(votes[0].charAt(i));
        }
        Collections.sort(list, (l1, l2) -> {
            for (int i = 0; i < votes[0].length(); i++) {
                if (rank[l1 - 'A'][i] != rank[l2 - 'A'][i]) {
                    return rank[l2 - 'A'][i] - rank[l1 - 'A'][i];
                }
            }
            return l1 - l2;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public String rankTeams1(String[] votes) {
        /*
         * 使用二维数组， temp[i][j] 表示第 i 队 第 j 名的票数
         * 
         * 为了方便排序后处理，我们将 temp[i][0] 作为该名参赛者的 id，比如 'A' 的 id 为 0， 'B' 的 id 为 1 然后
         * temp[i][1] - temp[i][26] 作为对应名次票数
         * 
         * 思路：我们先统计各个 id 对应名次的票数 然后根据名次票数、 id 大小进行排序 最后直接统计，过程如下代码注释
         */
        int len = votes.length;

        if (len == 1) {
            return votes[0];
        }

        // 总共多少个名次， 例如 ："ABC" ，3 位参赛者则有 3 个名次
        int size = votes[0].length();

        int[][] temp = new int[26][size + 1];

        // 将 0 号位置作为 id
        for (int i = 0; i < 26; i++) {
            temp[i][0] = i;
        }

        // 记录各个 id 对应的名次票数
        for (String str : votes) {
            for (int i = 0; i < size; i++) {
                temp[str.charAt(i) - 'A'][i + 1]++;
            }
        }

        /*
         * 自定义排序：按 各 名次 票数进行排序，前面 名次 票数多的排前面 如果所有名次票数都一样，那么根据 id 排序，小的排前面 比如假设
         * 'A' 和 'C' 所有名次票数都一样，但是 'A' 的 id 为 0， 'C' 的 id 为 2，因此 'A' 排在 'C' 的前面
         */
        Arrays.sort(temp, (a, b) -> {
            for (int i = 1; i < a.length; i++) {
                if (a[i] < b[i]) {
                    return 1;
                } else if (a[i] > b[i]) {
                    return -1;
                }
            }
            return a[0] - b[0];
        });

        /*
         * 我们不需要去判断 26 个 id 哪个没有参赛， 因为排序过后， 票数越少的越排在后面，那么没有参赛的 id 票数都为
         * 0，肯定都是排在最后 我们只需要使用变量 visited 记录遍历了多少个 id ，当 id == size（参赛人数） 时表示所有参赛
         * id 遍历完毕
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0, visited = 0; visited < size; i++, visited++) {
            sb.append((char) (temp[i][0] + 'A'));
        }
        return sb.toString();
    }
}
