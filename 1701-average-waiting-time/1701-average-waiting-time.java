class Solution {
    public double averageWaitingTime(int[][] customers) {
        int idleTime = 1;
        long waitingTime = 0;
        for(int customer[] : customers){
            if(idleTime <= customer[0]){
                idleTime = customer[0] + customer[1];
            }
            else{
                idleTime += customer[1];
            }
            waitingTime += (idleTime - customer[0]);
        }
        double average = waitingTime/ (double) customers.length;
        return average;
    }
}