class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        
        int low = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            sum += weights[i];
            low = Math.max(low, weights[i]);
        }
        
        int high = sum;
        
        while(low <= high){
            int mid = (low+high)/2;
            
            int maxDays;
            maxDays = noOfDays(weights, mid);
            
            if(maxDays <= days)
                high = mid-1;
            else 
                low = mid+1;
        }
        return low;
    }
    
    private int noOfDays(int[] weights, int capacity){
        int days = 1, load = 0;
        for(int i = 0; i < weights.length; i++){
            if(load + weights[i] > capacity){
                days +=1;
                load = weights[i];
            }
            else 
                load += weights[i];
        }
        return days;
    }
}