class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        return n + m - 2 * lcs(word1, word2);
    }
    
    public int lcs(String s, String t){
        int n = s.length();
        int m = t.length();
        
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)) curr[j] = 1 + prev[j-1];
                else
                    curr[j] = Math.max(prev[j], curr[j-1]); 
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }
}