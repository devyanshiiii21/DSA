import java.lang.Math;

class Solution {
    public int findNumbers(int[] nums) {
        int i = 0, count =0, count2 =0;
        for( i = 0; i < nums.length ; i++){
                count = (int)(Math.log10(nums[i])) +1;
                if(count %2 == 0){
                    count2++;
            }        
        }
        return count2;
    }
}