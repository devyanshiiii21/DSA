class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
      
        for(int j = 0; j <= amount; j++){
            if(j % coins[0] == 0){
                    prev[j] = j/coins[0];
                }
                else
                    prev[j] = (int)1e9;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if(coins[i-1] <= j){
                    take = 1 + curr[j-coins[i-1]];
                }
                curr[j] = Math.min(take, notTake);
                    
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        int ans = prev[amount];
        if(ans >= (int)1e9) return -1;
        return ans; 
    } 
    
}