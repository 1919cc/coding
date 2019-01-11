package com.classic.algorithm.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Leetcode200NumberOfIslands {
	// 76ms, 1.22%, slow!!!!
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) return 0; 
        List<Set<Integer>> islands = new LinkedList<>();
        
        int row = grid.length;
        int collumn = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collumn; j++) {
                if (grid[i][j] == '0') continue;
                Set<Integer> upIsland = null;
                if (i > 0) upIsland = getConnectIslands(islands, (i-1) * collumn + j);
                Set<Integer> leftIsland = null;
                if (j > 0) leftIsland = getConnectIslands(islands, i * collumn + j-1);
                
                if (upIsland == null && leftIsland == null) { // new island
                    Set<Integer> newIsland = new HashSet<>();
                    newIsland.add(i * collumn + j);
                    islands.add(newIsland);
                } else if (upIsland != leftIsland && upIsland != null && leftIsland != null) {
                    upIsland.addAll(leftIsland);
                    upIsland.add(i * collumn + j);
                    islands.remove(leftIsland);
                } else if (upIsland != null) upIsland.add(i * collumn + j);
                else if (leftIsland != null) leftIsland.add(i * collumn + j);
            }
        }
        
        return islands.size();
    }
    
    public Set<Integer> getConnectIslands(List<Set<Integer>> islands, int island) {
        for (Set<Integer> s : islands) {
            if (s.contains(island)) return s;
        }
        
        return null;
    }
    
    // DFS, 6ms, 86%
    public int numIslands2(char[][] grid) {
        int cnt = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    DFSTraverse(grid, i, j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public void DFSTraverse(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length
                && grid[i][j] == '1') {
            grid[i][j] = '2';
            
            DFSTraverse(grid, i-1, j); // up
            DFSTraverse(grid, i, j-1); // left
            DFSTraverse(grid, i+1, j); // down
            DFSTraverse(grid, i, j+1); // right
        }
    }
}