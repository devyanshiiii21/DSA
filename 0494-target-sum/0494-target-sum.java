class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        
        if ((target + sum) % 2 == 1 || (target + sum) < 0) {
            return 0;
        }
        
        int range = (target + sum)/2;
        
        return countSubset(nums, range, n);
    }
    private int countSubset(int[] arr, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
	    for(int i = 0; i <= n; i++){
	        dp[i][0] = 1;
	    }

	    for(int i = 1; i <= n; i++){
	        for(int j = 0; j <= sum; j++){
	            if(arr[i-1] <= j){
	                dp[i][j] = ( dp[i-1][j] + dp[i-1][j - arr[i-1]] );
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    return dp[n][sum];
    }
}