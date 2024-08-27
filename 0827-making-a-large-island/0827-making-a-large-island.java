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
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        // Step 1 -> Connecting components (unions)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                
                for(int ind = 0; ind < 4; ind++) {
                    int newr = i + dr[ind];
                    int newc = j + dc[ind];
                    
                    if(newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        int node = i * n + j;
                        int adjNode = newr * n + newc;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }

        // Step 2 -> Convert '0' to '1' and calculate max island size
        int mx = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) continue;
                
                HashSet<Integer> set = new HashSet<>();
                for(int ind = 0; ind < 4; ind++) {
                    int newr = i + dr[ind];
                    int newc = j + dc[ind];
                    
                    if(newr >= 0 && newr < n && newc >= 0 && newc < n && grid[newr][newc] == 1) {
                        set.add(ds.findParent(newr * n + newc));
                    }
                }

                int sizeTotal = 0;
                for (Integer parents : set) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }

        // Step 3 -> Check if all are '1's or all are '0's
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findParent(cellNo)));
        }

        return mx;
    }
}
