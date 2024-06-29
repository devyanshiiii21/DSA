class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, vis, n, m);
                }
            }
        }
        return count;
    }

    void dfs(int row, int col, char[][] grid, int[][] vis, int n, int m) {
        vis[row][col] = 1;

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, grid, vis, n, m);
            }
        }
    }
}




// class Pair {
//     int first; 
//     int second;
//     public Pair(int first, int second) {
//         this.first = first;
//         this.second = second;
//     }
// }

// class Solution {
//     private void bfs(int ro, int co, int[][] vis, char[][] grid) {
//         vis[ro][co] = 1;
//         Queue<Pair> q = new LinkedList<Pair>();
//         q.add(new Pair(ro, co)); 
        
//         int n = grid.length;
//         int m = grid[0].length;
                     
//         while(!q. isEmpty()) {
//             int row = q.peek().first;
//             int col = q.peek().second;
//             q. remove();

//             for(int delrow = -1; delrow<=1;delrow++) {
//                 for(int delcol = -1; delcol <= 1; delcol++){
//                     int nrow = row + delrow;
//                     int ncol = col + delcol;
//                     if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] = '1' && vis[nrow][ncol] == 0) {
//                         vis[nrow][ncol] = 1;
//                         q.add(new Pair(nrow, ncol));

//                     }
//                 }
//             }
//         }
//     }

// public int numIslands(char[][] grid) {
    

//     int n = grid. length;
//     int m = grid[0]. length;
//     int[][] vis = new int[n][m];
//     int cnt = 0;
//     for (int row = 0; row < n ; row++) {
//     for(int col = 0; col < m ;col++) {
//     if(vis[row][col] == 0 && grid[row][col] == '1') {
//         cnt++;
//         bfs(row, col, vis, grid);
//     }
//                                        }
//                                        }
//     return cnt;
        
//     }
    
// }