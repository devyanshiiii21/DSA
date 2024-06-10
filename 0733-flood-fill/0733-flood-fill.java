class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] ans = image;
        int initialCol = image[sr][sc];
        
        int[] delrow = {-1,0, +1,0};
        int[] delcol = {0,+1,0,-1};
        
        dfs(delrow, delcol, ans, image, initialCol, color, n, m, sr, sc);
        return ans;
        
    }
    
    public void dfs(int[] delrow, int[] delcol, int[][] ans, int[][] image, int initialCol,  int newcolor, int n, int m, int sr, int sc){
        ans[sr][sc] = newcolor;
        
        for(int i = 0; i < 4; i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && image[nrow][ncol] == initialCol && ans[nrow][ncol] != newcolor){
                dfs(delrow, delcol, ans, image, initialCol, newcolor, n, m, nrow, ncol);
            }
        }
    }
}