class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        
        int[] prev = new int[m+1];
        
        prev[0] = 1;
        
        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 1; j--){
                if(s.charAt(i-1) == t.charAt(j-1))
                    prev[j] = prev[j-1] + prev[j];
            }
        }
    
        
        return prev[m];
    }
    
    public int memoization(int i, int j, String s, String t, int[][] dp){
        if(j<0) return 1;
        if(i < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = memoization(i-1, j-1, s, t, dp) + memoization(i-1, j, s, t, dp);
        
        return dp[i][j] = memoization(i-1, j, s, t, dp);
    }

}