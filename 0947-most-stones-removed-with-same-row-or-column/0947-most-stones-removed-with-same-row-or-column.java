class DisjointSet{
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i = 0; i < n; i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    int findParent(int u){
        if(u == parent.get(u)) return u;
        
        int ultimateParent = findParent(parent.get(u));
        parent.set(u, ultimateParent); // Set the parent to ultimate parent
        return ultimateParent;
    }
    
    void unionBySize(int u, int v){
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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int[] row : stones){
            maxRow = Math.max(maxRow, row[0]);
            maxCol = Math.max(maxCol, row[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int[] it : stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        
        int count = 0;
        for(int key : map.keySet()){
            if(ds.findParent(key) == key){
                count++;
            }
        }
        return stones.length - count;
        
    }
}