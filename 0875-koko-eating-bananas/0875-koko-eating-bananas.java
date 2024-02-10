import java.lang.Math;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int low = 0, high = piles[n-1];
        int ans = Integer.MAX_VALUE;
        while(low<= high){
            int mid = (low+high)/2;
            int totalhr = hours(piles, mid);
            if(totalhr <= h){
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;
    }
    
    private int hours(int[] piles, int mid){
        int totalHours = 0;
        for(int i = 0; i<piles.length; i++){
            totalHours += Math.ceil((double) piles[i]/ (double) mid);
        }
        return totalHours;
    }
}