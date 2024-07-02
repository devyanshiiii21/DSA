class Solution {
    public int findDuplicate(int[] nums) {
        int[] count = new int[nums.length + 1];
        Arrays.fill(count, 0);
        
        for(int i = 0; i < nums.length; i++){
            if(count[nums[i]] == 0)
                count[nums[i]] = 1;
            else
                return nums[i];
        }
        return 0;
    }
}