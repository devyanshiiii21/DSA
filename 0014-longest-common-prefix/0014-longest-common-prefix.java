class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length -1];
        
        int count = 0;
        
        while(count<str1.length() && count < str2.length()){
            if(str1.charAt(count) == str2.charAt(count)){
                count++;
            }
            else
                break;
        }
        return str1.substring(0, count);
    }
}