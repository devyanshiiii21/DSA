import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
         for (int[] row : dp) 
            Arrays.fill(row, -1); 
     
        return helper(m-1, n-1, dp);
    }
    
    public int helper(int i, int j, int[][] dp){
        
 //         Base case
        if(i == 0 && j == 0)
            return 1;
        if(i < 0 || j < 0)
            return 0;
        
        if(dp[i][j] != -1) 
            return dp[i][j];
        
        int left = helper(i-1, j, dp);
        int up = helper(i, j-1, dp);
        
        dp[i][j] = left+up;
        
        return dp[i][j];
        
    }
}