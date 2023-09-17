import java.util.Collections;

class Solution {
    public String reverseWords(String s) {
        String[] temp = s.split("\\s+");
        StringBuilder result = new StringBuilder();
 
        for (int i = temp.length-1; i >= 0; i--) {
            if (i == 0)
                result.append(temp[i]) ;
            else
                result.append(temp[i] + " ");
        }
        return result.toString().trim();
    }
}