class Solution {
    private boolean detectCycle(int node, boolean[] vis, boolean[] pathVis, int[][] graph, boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        
        for (int adjNode : graph[node]) {
            if (!vis[adjNode]) {
                if (detectCycle(adjNode, vis, pathVis, graph, check)) {
                    check[node] = false;
                    return true;
                }
            } else if (pathVis[adjNode]) {
                check[node] = false;
                return true;
            }
        }
        
        pathVis[node] = false;
        check[node] = true;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        
        boolean[] vis = new boolean[n];
        boolean[] check = new boolean[n];

        Arrays.fill(vis, false);
        Arrays.fill(check, false);

        
        boolean[] pathVis = new boolean[n];
        Arrays.fill(pathVis, false);
        
        ArrayList<Integer> safeNodes = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            detectCycle(i, vis, pathVis, graph, check);
        }
        
        for(int i = 0; i < n; i++){
            if(check[i] == true)
                safeNodes.add(i);
        }
        return safeNodes;
    }
}