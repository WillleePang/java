package com.willlee.leetcode;

import java.util.Arrays;

public class Leetcode743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 构建邻接矩阵，用于存放各个点到各个点的距离
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = -1;
            }
        }

        // 遍历times填充邻接矩阵
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 存放K到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // 初始化distance为K到各个节点的距离
        for (int i = 1; i <= N; i++) {
            distance[i] = graph[K][i];
        }
        // K到达K本身的节点初始化为 0

        distance[K] = 0;
        // 判断是否找到K到达该点最短路径
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;
        // 遍历除K本身节点之外的所有N-1个节点
        for (int i = 1; i <= N - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            // 遍历所有节点，找到离K最近的节点
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }
            // 标记最近距离节点找到
            visited[minIndex] = true;

            // 根据刚刚找到的最短距离节点，通过该节点更新K节点与其他的节点的距离
            for (int j = 1; j <= N; j++) {
                // 如果已更新的最短节点可以到达当前节点
                if (graph[minIndex][j] != -1) {
                    if (distance[j] != -1) {
                        // 取之前路径与当前更新路径的最小值
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    } else {
                        // 该节点是第一次访问，直接更新
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }
        int maxDistance = 0;
        // 遍历最大值，如果有节点未被访问，返回-1，否则返回最大最短的路径
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }
        return maxDistance;
    }

    private final int INF = 0X3F3F3F3F;

    public int networkDelayTime1(int[][] times, int N, int K) {
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {// 构建图
            for (int j = 0; j <= N; j++) {
                graph[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] edge : times) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        boolean[] checked = new boolean[N + 1];
        for (int minN = K, newMin = 0; minN > 0; minN = newMin) {// 实现Dijkstra's，松弛与寻找最近节点合并进行。
            checked[minN] = true;
            newMin = 0;
            for (int j = 1; j < N + 1; j++) {
                graph[K][j] = Math.min(graph[K][j], graph[K][minN] + graph[minN][j]);
                if (!checked[j] && graph[K][j] < graph[K][newMin]) {
                    newMin = j;
                }
            }
        }

        int res = -1;
        for (int j = 1; j <= N; j++) {
            res = Math.max(res, graph[K][j]);
            if (res == INF)
                return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode743 a = new Leetcode743();
        a.networkDelayTime1(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2);
    }
}
