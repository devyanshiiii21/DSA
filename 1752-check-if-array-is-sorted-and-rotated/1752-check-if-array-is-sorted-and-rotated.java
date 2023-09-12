class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i]< nums[(i-1)%n])
                count ++;
        }
        if(nums[n-1] > nums[0]){
            count++;
        }
        if(count <= 1)
            return true;
        return false;
    }
}