class Solution {
    public boolean search(int[] nums, int target) {
        
        int low =0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            
            
            if(nums[mid] == target){
                return true;
            } 
//             Handle Duplicates
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low+1;
                high = high -1;
                continue;
            }
            
//             Left part completely sorted
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid-1;
                }
                else
                    low = mid+1;
            }
//             Right part completely sorted
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
                
        }
        return false;
    }
}
    