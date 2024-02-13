class Solution {
    public String firstPalindrome(String[] words) {
        String ans = "";
        for(String str: words){
            if(isPalindrome(str)){
                ans = str;
                break;
            }
        }
        return ans;
    }
    
    public Boolean isPalindrome(String str){
        int low = 0, high = str.length()-1;
        
        while(low<high){
            if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }
            else
                return false;
        }
        
        if(low>= high){
            return true;
        }
        return false;
    }
}