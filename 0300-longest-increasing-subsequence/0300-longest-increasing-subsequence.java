class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
//    Tabulation, a different method
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[i] > nums[prev]){
                    dp[i] = Math.max(1+dp[prev], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
        
// Tabulation
//         int[][] dp = new int[n+1][n+1];
//         for(int ind = n-1; ind >= 0; ind--){
//             for(int prev = ind - 1; prev >= -1; prev--){
                
//                 int len = 0 + dp[ind + 1][prev+1];
//                 if(prev == -1 || nums[ind] > nums[prev])
//                     len = Math.max(len, 1+dp[ind+1][ind+1]);
                
//                 dp[ind][prev+1] = len;
//             }  
//         }     
        
//         return dp[0][0];                                 
        
// }
//     Memoization
    public int lis(int ind, int prev, int n, int[][] dp, int[] nums){
        if(ind == n) return 0;
        
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        
        int len;
        len = lis(ind + 1, prev, n, dp, nums);
        if(prev == -1 || nums[ind] > nums[prev]){
            len = Math.max(len, 1+lis(ind+1, ind, n, dp, nums));
        }
        
        return dp[ind][prev+1] = len;
    }
}