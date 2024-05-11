class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Calculate the maximum amount if the first house is robbed
        int max1 = robHelper(nums, 0, n - 2);
        
        // Calculate the maximum amount if the first house is not robbed
        int max2 = robHelper(nums, 1, n - 1);
        
        // Return the maximum of the two cases
        return Math.max(max1, max2);
    }
    
    // Helper function to calculate the maximum amount that can be robbed
    private int robHelper(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        
        return currMax;
    }
}
