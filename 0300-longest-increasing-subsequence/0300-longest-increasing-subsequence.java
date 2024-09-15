class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return lis(0, -1, n, dp, nums);
    }
    
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