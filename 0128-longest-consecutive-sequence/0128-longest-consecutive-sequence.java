class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }
        
        for(int i : set){
            if(!set.contains(i-1)){
                int x = i;
                int count = 1;
                
                while(set.contains(x+1)){
                    count++;
                    x = x + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}