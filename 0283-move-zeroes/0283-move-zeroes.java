import java.util.*;

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length; 
        for (int num:nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i<n){
            nums[i] = 0;
            i++;
        }
    }
}
