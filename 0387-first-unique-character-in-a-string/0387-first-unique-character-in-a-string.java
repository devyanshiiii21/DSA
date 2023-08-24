class Solution {
    public int firstUniqChar(String s) {
        int[] charFrequency = new int[26];
        
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charFrequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}