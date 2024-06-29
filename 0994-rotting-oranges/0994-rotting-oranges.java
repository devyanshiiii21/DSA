import java.util.*;

class Node {
    int row;
    int col;
    int time;

    public Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        Queue<Node> q = new LinkedList<>();

        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Node(i, j, 0)); 
                    vis[i][j] = 2; 
                }
                if (grid[i][j] == 1) freshCount++;
            }
        }

        int maxTime = 0;
        int rottenCount = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int r = currentNode.row;
            int c = currentNode.col;
            int t = currentNode.time;

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    q.add(new Node(nrow, ncol, t + 1)); 
                    vis[nrow][ncol] = 2; 
                    rottenCount++;
                    maxTime = t + 1;
                }
            }
        }

        if (freshCount != rottenCount) return -1;

        return maxTime;
    }
}
