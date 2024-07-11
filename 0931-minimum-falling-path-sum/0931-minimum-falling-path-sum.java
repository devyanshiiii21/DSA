// Space Optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        
        int prev[] = new int[n];
        Arrays.fill(prev, 0);
        
        int curr[] = new int[n];
        Arrays.fill(curr, 0);
        
        // Base case
        for(int j = 0; j<n; j++){
            prev[j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int st = matrix[i][j] + prev[j];
                
                int leftdg = matrix[i][j];
                if(j-1 >= 0) leftdg += prev[j-1];
                else leftdg = Integer.MAX_VALUE;

                int rightdg = matrix[i][j];
                if(j+1 < n) rightdg += prev[j+1];
                else rightdg = Integer.MAX_VALUE;

                curr[j] = Math.min(st, Math.min(leftdg, rightdg));
            }
            for(int j = 0; j < n; j++) {
                prev[j] = curr[j];
            }
        }
        
        for(int j = 0; j < n; j++){
            min = Math.min(min, prev[j]);
        }
        return min;
    }

}




// // Tabulation
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
//         int min = Integer.MAX_VALUE;
        
//         int dp[][] = new int[n][n];
//         for(int[] row : dp){
//             Arrays.fill(row, 0);
//         }
        
//         // Base case
//         for(int j = 0; j<n; j++){
//             dp[0][j] = matrix[0][j];
//         }

//         for(int i = 1; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 int st = matrix[i][j] + dp[i-1][j];
                
//                 int leftdg = matrix[i][j];
//                 if(j-1 >= 0) leftdg += dp[i-1][j-1];
//                 else leftdg = Integer.MAX_VALUE;

//                 int rightdg = matrix[i][j];
//                 if(j+1 < n) rightdg += dp[i-1][j+1];
//                 else rightdg = Integer.MAX_VALUE;

//                 dp[i][j] = Math.min(st, Math.min(leftdg, rightdg));
//             }
//         }
//         for(int j = 0; j < n; j++){
//                 min = Math.min(min, dp[n-1][j]);
//             }

//         return min;
//     }

// }


// Memoization
// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
        
//         int dp[][] = new int[n][n];
//         for(int[] row : dp){
//             Arrays.fill(row, -1);
//         }
//         int min = Integer.MAX_VALUE;
//         for(int j = 0; j < n; j++){
//             min = Math.min(min, helper(n-1, j, matrix, dp, n));
//         }
        
//         return min;
//     }
    
//     private int helper(int i, int j, int[][] matrix, int[][] dp, int n){
//         if(j < 0 || j >= n) return (int) Math.pow(10, 9);
//         if(i == 0) return matrix[0][j];
        
//         if(dp[i][j] != -1) return dp[i][j];
        
//         int st = matrix[i][j] + helper(i-1, j, matrix, dp, n);
//         int leftdg = matrix[i][j] + helper(i-1,j-1, matrix, dp, n);
//         int rightdg = matrix[i][j] + helper(i-1, j+1, matrix, dp, n);
        
//         return dp[i][j] = Math.min(st, Math.min(leftdg, rightdg));
//     }
// }