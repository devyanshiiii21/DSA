class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        partioning(s, 0, path, ans);
        return ans;
    }
    
    private void partioning(String s, int ind, List<String> path, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = ind; i < s.length(); ++i){
            if(isPalindrome(ind, i, s)){
                path.add(s.substring(ind, i+1));
                partioning(s, i+1, path, ans);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(int ind, int i, String s){
        while(ind <= i){
            if(s.charAt(ind) != s.charAt(i)){
                return false;
            }
            ind++;
            i--;
        }
        return true;
    
    }
}