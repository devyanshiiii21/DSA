class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxlen = 0;
        int l = 0, r = 0;
        int[] hash = new int[255];
        for(int i = 0; i < 255; i++){
            hash[i] = -1;
        }
        int n = s.length();
        while(r<n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] +1;
                }
            }
            len = r-l+1;
            maxlen = Math.max(len, maxlen);
            
            hash[s.charAt(r)] = r;
            r++;
        }
        
        return maxlen;
    }
}