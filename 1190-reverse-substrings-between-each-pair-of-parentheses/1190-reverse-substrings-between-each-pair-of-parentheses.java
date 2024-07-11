class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch != ')'){
                st.push(ch);
            }
            else{
                ArrayList<Character> list = new ArrayList<>();
                while(!st.isEmpty() && st.peek() != '(') list.add(st.pop());
                st.pop();
                
                for(char c : list){
                    st.push(c);
                }
            } 
        }
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        return ans.toString();
    }
}