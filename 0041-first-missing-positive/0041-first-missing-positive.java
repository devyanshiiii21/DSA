import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int firstMissingPositive(int[] nums) {
       int posValue = 1;
        Arrays.sort(nums);
        for(int value : nums){
            if(value<=0)
                continue;
            if(value == posValue)
                posValue ++;
            if(value > posValue)
                break;
        }
        return posValue;
        }
        
    }