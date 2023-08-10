class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0; 
        int end = nums.length-1;
        int[] result = {-1, -1};
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                int left = mid;
                int right = mid;
                
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                
                result[0] = left;
                result[1] = right;
                return result;
            }
            else if(target < nums[mid]){
                end = mid -1;
            }
            else if(target > nums[mid]){
                start = mid +1;
            }
        }
        return result;
    }
}