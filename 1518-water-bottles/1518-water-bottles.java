class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0;
        
        while(numBottles >= numExchange){
            int refilled = 0;
            
            refilled = numBottles/numExchange;
            
            emptyBottles += refilled * numExchange;
            numBottles -= refilled * numExchange;
            
            numBottles += refilled;
        }
        return numBottles + emptyBottles;
    }
}