class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0 , maxCount =0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
            else
                count = 0;
            
            maxCount = Math.max(maxCount, count);
        }
        
        if(maxCount >= 3) return true;
        return false;
    }
}