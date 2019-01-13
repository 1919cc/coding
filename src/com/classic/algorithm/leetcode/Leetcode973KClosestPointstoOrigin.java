package com.classic.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode973KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Map<Integer, int[]> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int dist = x*x + y*y;
            map.put(dist, points[i]);
            queue.add(dist);
        }
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = map.get(queue.poll());
        }
        
        return res;
    }
}
