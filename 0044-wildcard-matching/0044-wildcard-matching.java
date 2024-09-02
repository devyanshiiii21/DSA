class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        Boolean[][] dp = new Boolean[n][m];
        
        return helper(n - 1, m - 1, s, p, dp);
    }
    
    public boolean helper(int i, int j, String s, String p, Boolean[][] dp) {
        // Base cases
        if (i < 0 && j < 0) return true;  // Both strings and pattern exhausted
        if (j < 0) return false;  // Pattern exhausted but string not exhausted
        if (i < 0) {  // String exhausted, check if pattern can match empty string
            for (int ind = 0; ind <= j; ind++) {
                if (p.charAt(ind) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];
        
        // Matching characters or '?'
        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            dp[i][j] = helper(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j) == '*') {
            // '*' can match zero characters or one or more characters
            dp[i][j] = helper(i - 1, j, s, p, dp) || helper(i, j - 1, s, p, dp);
        } else {
            dp[i][j] = false;  // Characters don't match
        }

        return dp[i][j];
    }
}
