class Pair{
    int row;
    int col;
    int steps;
    
    public Pair(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] vis = new int[n][m];
        int [][] dist = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
                else
                    vis[i][j] = 0;
            }
        }
        
        int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
        
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int st = q.peek().steps;
            q.remove();
            
            dist[r][c] = st;
            
            for(int i = 0;i<4;i++) {
	            int nrow = r + delrow[i]; 
	            int ncol = c + delcol[i]; 
                
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0)  {
	                vis[nrow][ncol] = 1; 
    	            q.add(new Pair(nrow, ncol, st+1));  
	            } 
	        }
            
        }
        return dist;
    }
}