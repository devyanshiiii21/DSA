class DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findParent(int u){
        if(u == parent.get(u)) return u;
        
        int ultimateParent = findParent(parent.get(u));
        parent.set(u, ultimateParent); 
        return ultimateParent;
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v) return;
        
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
    
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        
        for(int[] row : connections){
            int u = row[0];
            int v = row[1];
            
            if(ds.findParent(u) == ds.findParent(v)) extraEdges++;
            else
                ds.unionBySize(u, v);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i) count++;
        }
        
        int ans = 0;
        ans = count-1;
        
        if(extraEdges >= ans) return ans;
        else
            return -1;
    }
}