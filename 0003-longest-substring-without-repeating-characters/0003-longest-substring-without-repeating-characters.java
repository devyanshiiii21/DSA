class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxlen = 0;
        
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            int[] hash = new int[255];
            for(int j = i; j < n; j++){
                if(hash[s.charAt(j)] == 1) break;
                
                len = j-i+1;
                maxlen = Math.max(len, maxlen);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxlen;
    }
}