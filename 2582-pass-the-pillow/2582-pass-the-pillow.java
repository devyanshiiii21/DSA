class Solution {
    public int passThePillow(int n, int time) {
        boolean revDir = false;
        int currInd = 1;
        int currTime = 0;
        
        while(currTime < time){
            if(!revDir) currInd++;
            else currInd--;
            
            if(currInd == 1 || currInd == n) revDir = !revDir;
            
            currTime++;
        }
        return currInd;
    }
}