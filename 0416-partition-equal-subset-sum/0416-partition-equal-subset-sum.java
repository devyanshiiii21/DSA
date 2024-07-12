class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum+=nums[i];
        }
        int subsetSum = totalSum/2;
        
        if(totalSum % 2 !=0) return false;
        
        return isSubsetSum(nums.length, nums, subsetSum);
    }
    
    private Boolean isSubsetSum(int N, int arr[], int sum){
        boolean[] prev = new boolean[sum+1];
        
        prev[0] = true;
        
        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }
        
        for(int ind = 1; ind < N; ind++){
            
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            
            for(int target = 1; target <= sum; target++){
                boolean notTake = prev[target];
                
                boolean take = false;
        
                if(target >= arr[ind]) take = prev[target-arr[ind]];
                
                curr[target] = (take || notTake) ? true : false;
            }
            prev = curr;
        }
        return prev[sum];
    }
}