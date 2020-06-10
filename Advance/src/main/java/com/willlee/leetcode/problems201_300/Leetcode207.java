package com.willlee.leetcode.problems201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode207 {
    public static void main(String[] args) {
        Leetcode207 a = new Leetcode207();
        a.canFinish1(6, new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 1 }, { 2, 4 }, { 3, 4 }, { 5, 3 }, { 5, 4 } });
    }

    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 构造邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] item = prerequisites[i];
            indegrees[item[1]]++;// 每个元素的入度数
            adjacency.get(item[0]).add(item[1]);// 找到所有自己指向的节点
        }
        // 入度数为0的节点
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // DFS
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }

    // DFS
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] item : prerequisites) {
            adjacency.get(item[0]).add(item[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1)
            return false;
        if (flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            if (!dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}
