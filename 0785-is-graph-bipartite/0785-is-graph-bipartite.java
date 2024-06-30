class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int m = graph[0]. length;
        
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < n; i++){
            if(color[i] == -1)
                if(dfs(i, 0, color, graph, n, m) == false) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int node, int col, int[] color, int[][] graph, int n, int m){
        color[node] = col;
        
        for(int ele: graph[node]){
                if(color[ele] == -1){
                    if(dfs(ele, 1-col, color, graph, n , m) == false) return false;
                }
                else if(color[ele] == col) return false;
            }

        
    return true;
    }
}