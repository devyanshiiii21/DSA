import java.util.*;

class Pair {
    int distance;
    int row;
    int column;
    
    Pair(int distance, int row, int column) {
        this.distance = distance;
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If the starting or ending point is blocked, there's no path.
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(1, 0, 0)); // Start from the first cell with distance 1
        dist[0][0] = 1;
        
       
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        while (!que.isEmpty()) {
            Pair current = que.poll();
            int dis = current.distance;
            int r = current.row;
            int c = current.column;
            
            // If we've reached the bottom-right corner, return the distance
            if (r == n-1 && c == n-1) {
                return dis;
            }
            
            for (int i = 0; i < 8; i++) {
                int row = r + dr[i];
                int col = c + dc[i];
                
                if (row >= 0 && row < n && col >= 0 && col < n 
                && grid[row][col] == 0 && dis + 1 < dist[row][col]) {
                    dist[row][col] = dis + 1;
                    que.add(new Pair(dist[row][col], row, col));
                }
            }
        }
        
        return -1;
    }
}
