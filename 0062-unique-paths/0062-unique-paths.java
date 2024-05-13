import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
                
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) dp[0][0] = 1;
                
                else{
                    int up = 0, left = 0;
                    if(i > 0)
                        up = dp[i-1][j];
                    if(j>0)
                        left = dp[i][j-1];

                    dp[i][j] = up+left;
                }
                
            }
        }
     
        return dp[m-1][n-1];
    }
    
//     public int helper(int i, int j, int[][] dp){
        
//  //         Base case
//         if(i == 0 && j == 0)
//             return 1;
//         if(i < 0 || j < 0)
//             return 0;
        
//         if(dp[i][j] != -1) 
//             return dp[i][j];
        
//         int left = helper(i-1, j, dp);
//         int up = helper(i, j-1, dp);
        
//         dp[i][j] = left+up;
        
//         return dp[i][j];
        
//     }
}