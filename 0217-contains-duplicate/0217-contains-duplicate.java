import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
//         Creating HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        
//         Creating Hash Table
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }    
        
//         Map Traversal

        for(int key : map.keySet()){
            if(map.get(key) > 1){
                return true;
            }
        }
        return false;
    }
}