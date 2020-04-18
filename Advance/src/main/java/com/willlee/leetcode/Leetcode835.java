package com.willlee.leetcode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode835 {

    /*
     * 解题思路: 本题核心的思路是如何正确的遍历出两个二维数组的所有重叠情况。
     *
     * 我们可以假设两个二维数组为 A，B。我们让A静止，B可以随意的移动
     *
     * 假设数组的长度为2，那么B相对A的偏移量有[0,0] [0,1] [1,0] [1,1] [-0,-0] [-0,-1] [-1,-0]
     * [-1,-1]
     * 
     * 假设数组的长度为3，那么B相对A的偏移量有[0,0] [0,1] [0,2] [1,0] [1,1] [1,2] [2,0] [2,1]
     * [2,2] [-0,-0] [-0,-1] [-0,-2] [-1,-0] [-1,-1] [-1,-2] [-2,-0] [-2,-1]
     * [-2,-2]
     *
     * 假设数组的长度为4，那么B相对A的偏移量有 4 * 4 * 2
     *
     * 可以明显的发现一共有 length * length * 2 种情况，这需要一个双层循环
     *
     * 在对应的每一种的偏移量下，我们要计算出对应情况下的重叠 count 的值。这需要一个双层循环。
     *
     * 综上所述，我们需要一个四层循环就可以计算出最大重叠 max 的值
     *
     */
    public static int largestOverlap(int[][] A, int[][] B) {
        Integer length = A.length;
        Integer max = 0;
        for (int offsetX = 0; offsetX < length; offsetX++) {
            for (int offsetY = 0; offsetY < length; offsetY++) {
                int count1 = 0;
                int count2 = 0;
                for (int i = 0; i + offsetX < length; i++) {
                    for (int j = 0; j + offsetY < length; j++) {
                        // 第二个矩阵B相对A向右偏移
                        if (A[i + offsetX][j + offsetY] == B[i][j] && B[i][j] == 1)
                            count1++;

                        // 第二个矩阵B相对A向左偏移
                        if (A[i][j] == B[i + offsetX][j + offsetY] && A[i][j] == 1)
                            count2++;
                    }
                }
                System.out.println(count1 + " " + count2);
                max = Math.max(Math.max(count1, count2), max);
            }
        }
        return max;
    }

    // 太慢了，不建议用，但是思路比较清晰
    public int largestOverlap1(int[][] A, int[][] B) {
        int N = A.length;
        List<Point> A2 = new ArrayList<Point>(), B2 = new ArrayList<Point>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 将等于1的点添加进去。
                if (A[i][j] == 1)
                    A2.add(new Point(i, j));
                if (B[i][j] == 1)
                    B2.add(new Point(i, j));
            }
        }
        Set<Point> Bset = new HashSet<Point>(B2);
        int ans = 0;
        Set<Point> seen = new HashSet<Point>();
        for (Point a : A2) {
            // 对应A中每个1去与B中每个1去重合
            for (Point b : B2) {
                // 这个delta可以理解为A中的点a要走到b这个点需要走多少。例如A中第一个1，走到B中第1个1
                // 需要右移动1（b.x-a.x），向下移动1（b.y-a.y）。
                Point delta = new Point(b.x - a.x, b.y - a.y);
                // 为了避免相同的位移。比如A中（0，1）处的1想到B中（1，2）处的1也是需要向右移动1，向下移动1
                // 那么我们之前计算过一遍就不需要再计算一次了。
                if (!seen.contains(delta)) {
                    seen.add(delta);
                    int cand = 0;
                    // 对于A2中的每个点加上位移，去判断是否与B重合
                    for (Point p : A2) {
                        if (Bset.contains(new Point(p.x + delta.x, p.y + delta.y)))
                            cand++;
                    }
                    ans = Math.max(ans, cand);
                }
            }
        }

        return ans;
    }

}
