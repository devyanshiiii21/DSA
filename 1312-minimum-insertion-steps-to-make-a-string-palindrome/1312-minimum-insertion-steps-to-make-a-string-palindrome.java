class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int lps = longestPalindromeSubseq(s);
        
        return n-lps;
    }
    
    public int longestPalindromeSubseq(String s) {
        return  lcs(s, rev(s));
    }
    
    public String rev(String s){   
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }
    
    public int lcs(String s, String t){
        int n = s.length();
        int m = t.length();
        
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = 1 + prev[j-1];
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