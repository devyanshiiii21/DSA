class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == '('){
               if(count != 0){
                    sb.append(c);
                }
                count++;
            }
            else{
                if(count != 1){
                    sb.append(c);
                }
                count--;
            }
        }
       return sb.toString();
    }
}