class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
      
        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0){
                    dp[0][j] = j/coins[0];
                }
                else
                    dp[0][j] = (int)1e9;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i-1] <= j){
                    take = 1 + dp[i][j-coins[i-1]];
                }
                dp[i][j] = Math.min(take, notTake);
                    
            }
        }
        int ans = dp[n][amount];
        if(ans >= (int)1e9) return -1;
        return ans; 
    } 
    
}