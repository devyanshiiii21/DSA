class Solution {
    public boolean isValid(String s) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(st.isEmpty()) return false;
                char top = st.pop();
                
                if((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '['))                     {return false;}
            }
        }
        return st.isEmpty();
    }
}