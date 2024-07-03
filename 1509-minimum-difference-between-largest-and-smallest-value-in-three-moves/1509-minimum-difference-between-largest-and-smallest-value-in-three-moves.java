class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) return 0; // If there are 4 or fewer elements, we can make all elements the same

        Arrays.sort(nums); 

        // Evaluate the four scenarios:
        // 1. Remove three largest elements
        // 2. Remove two largest and one smallest element
        // 3. Remove one largest and two smallest elements
        // 4. Remove three smallest elements
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        result = Math.min(result, nums[n-1] - nums[3]); // Remove the three smallest elements
        result = Math.min(result, nums[n-2] - nums[2]); // Remove the two smallest and one largest
        result = Math.min(result, nums[n-3] - nums[1]); // Remove the one smallest and two largest
        result = Math.min(result, nums[n-4] - nums[0]); // Remove the three largest elements

        return result;
    }
}