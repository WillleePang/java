package com.willlee.leetcode;

public class Leetcode1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (distance == null || distance.length == 0) {
            return 0;
        }

        int sum = 0;
        int dis = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= Math.min(start, destination) && i < Math.max(start, destination)) {
                dis += distance[i];
            }
        }
        return Math.min(dis, sum - dis);
    }

    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int first = 0, second = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                first += distance[i];
            } else {
                second += distance[i];
            }
        }
        return first > second ? second : first;
    }
}
