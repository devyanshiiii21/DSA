class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length-1;
        int m = s.length-1;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
         while(n >= 0 && m >=0){
            if(s[m] >= g[n]){
                count++;
                n--;
                m--;
            }
            else{
                n--;
            }
        }
        return count;
    }
}