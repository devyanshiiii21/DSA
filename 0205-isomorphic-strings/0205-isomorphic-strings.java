class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        int[] stoT = new int[128];
        int[] ttoS = new int[128];
        
        StringBuilder sbT = new StringBuilder();
        StringBuilder sbS = new StringBuilder();
        
        Arrays.fill(stoT, -1);
        Arrays.fill(ttoS, -1);
        
        for(int i = 0; i < s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            
            if(stoT[s1] == -1) stoT[s1] = t1;
            if(ttoS[t1] == -1) ttoS[t1] = s1;
            
            if(stoT[s1] != t1 || ttoS[t1] != s1) return false;
        }
        return true;
    }
}