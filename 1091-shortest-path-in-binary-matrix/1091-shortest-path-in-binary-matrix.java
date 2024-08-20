import java.util.LinkedList;
import java.util.Queue;

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
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1; // If start or end is blocked, return -1
        }

        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(1, 0, 0));
        dist[0][0] = 1; // Starting cell distance should be 1
        
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!que.isEmpty()) {
            Pair curr = que.poll();
            int dis = curr.distance;
            int r = curr.row;
            int c = curr.column;

            // If we've reached the destination, return the distance
            if (r == n - 1 && c == n - 1) {
                return dis;
            }

            for (int i = 0; i < 8; i++) {
                int row = r + dr[i];
                int col = c + dc[i];

                if (row >= 0 && row < n && col >= 0 && col < n 
                    && grid[row][col] == 0 && dis + 1 < dist[row][col]) {
                    dist[row][col] = dis + 1;
                    que.add(new Pair(dis + 1, row, col));
                }
            }
        }

        return -1;
    }
}
