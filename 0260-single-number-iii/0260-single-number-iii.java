import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }
        
        List<Integer> arrlist = new ArrayList<Integer>();
        
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                arrlist.add(key);
            }
        }
        int[] arr = new int[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            arr[i] = arrlist.get(i);
        }


        return arr;
        
    }
}