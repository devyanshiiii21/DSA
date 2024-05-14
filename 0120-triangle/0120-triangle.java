class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(0, 0, m, n, triangle, dp);
    }
    
    public int helper(int i, int j, int m, int n, List<List<Integer>> triangle, int[][] dp){
        
        
//         Base case
        if(i == n-1)
            return triangle.get(n-1).get(j);
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        
        
        int down = triangle.get(i).get(j) + helper(i+1, j, m, n, triangle, dp);
        int diagnol = triangle.get(i).get(j) + helper(i+1, j+1, m, n, triangle, dp);
        
        dp[i][j] = Math.min(down, diagnol);
        
        return dp[i][j];
    }
}