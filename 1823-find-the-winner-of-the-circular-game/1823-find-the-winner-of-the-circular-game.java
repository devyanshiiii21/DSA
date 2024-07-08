class Solution {
    private int findTheWinnerr(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Total TC : N + N ^ 2
        
//         O(N)
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        
        
//         O(N)
        int i = 0;
        while(list.size() > 1){
            i = (i+(k-1)) % list.size();
            list.remove(i); // O(N)  
        }
        return list.get(0);
    }
//     Better solution
//     Delete at front and Add at rear
//     Total TC : N + N * K
    
    
    // Optimal Solution
    // Recursive approach
    public int findTheWinner(int n, int k){
        int index = helper(n, k);
        return index + 1;
    }
    
    private int helper(int n, int k){
        if(n == 1) return 0;
        
        return ( helper(n-1, k) + k) % n;
    }
    
}