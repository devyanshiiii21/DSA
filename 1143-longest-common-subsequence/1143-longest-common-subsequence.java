class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return tabulation(text1, text2, dp, n, m);
    }
//     Memoization
    public int lcs(int i, int j, String s, String t, int[][] dp){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + lcs(i-1, j-1, s, t, dp);
        
        return dp[i][j] = 0 + Math.max(lcs(i-1, j, s, t, dp), lcs(i, j-1, s, t, dp));
    }
    
//     Tabulation
    public int tabulation(String s, String t, int[][] dp, int n, int m){
//         Base cases
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]); 
            }
        }
        return dp[n][m];
    }
}