import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < s.length(); k++){
            char c = s.charAt(k);
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }
        
        String newString = sb.toString().toLowerCase();
        int i = 0;
        int j = newString.length() - 1;
        
        while (i < j) {
            if (newString.charAt(i) != newString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
