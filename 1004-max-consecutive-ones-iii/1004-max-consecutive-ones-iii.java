class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        // for(int i = 0; i < nums.length; i++){
        //     int zeros = 0;
        //     for(int j = i; j < nums.length; j++){
        //         if(nums[j] == 0) zeros++;
        //         if(zeros <= k){
        //             maxlen = Math.max(maxlen, j-i+1);
        //         }
        //         else break;
        //     }
        // }
        // return maxlen;
        
        int l = 0, r = 0, zeros = 0, len = 0;
        while(r<nums.length){
            if(nums[r] == 0) zeros++;
             while(zeros > k){
                 if(nums[l] == 0) zeros--;
                 l++;
             }   
             if(zeros<=k){
                 len = r-l+1;
                 maxlen = Math.max(len, maxlen);
             }
            
            r++;
        }
        return maxlen;
    }
}