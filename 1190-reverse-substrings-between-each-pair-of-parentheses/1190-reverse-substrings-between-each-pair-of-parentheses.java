class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        int pair[] = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else if(ch == ')'){
                int openIndex = st.pop();
                pair[i] = openIndex;
                pair[openIndex]  = i;
            } 
        }
        
        int dir = 1;
        int curr = 0;
        while(curr < s.length()){
            char ch = s.charAt(curr);
            if(ch == '(' || ch == ')'){
                curr = pair[curr];
                dir = -1 * dir;
            }
            else
                ans.append(ch);
            
            curr += dir;
        }
        return ans.toString();
    }
}