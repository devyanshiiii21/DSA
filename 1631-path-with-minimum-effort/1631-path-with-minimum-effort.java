class PQ{
    int distance;
    int row;
    int col;
    PQ(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        
        PriorityQueue<PQ> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        
        
        dist[0][0] = 0;
        pq.add(new PQ(0, 0, 0));
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();
            
            if(row == n-1 && col == m-1) return dis;
            
            for(int i = 0; i < 4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < m){
                    int effort =  Math.max(Math.abs(heights[row][col] - heights[newr][newc]), dis);
                    
                    if(effort < dist[newr][newc]){
                        dist[newr][newc] = effort;
                        pq.add(new PQ(effort, newr, newc));
                    }
                }
            }
        }
        return 0;
    }
}