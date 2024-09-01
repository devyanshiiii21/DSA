class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return lcs(n-1, m-1, text1, text2, dp);
    }
    
    public int lcs(int i, int j, String s, String t, int[][] dp){
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 1 + lcs(i-1, j-1, s, t, dp);
        
        return dp[i][j] = 0 + Math.max(lcs(i-1, j, s, t, dp), lcs(i, j-1, s, t, dp));
    }
}