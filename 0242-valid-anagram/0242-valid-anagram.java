import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String sortedS = new String(s1);
        String sortedT = new String(t1);
        if(sortedS.equals(sortedT))
            return true;
        return false;
    }
}