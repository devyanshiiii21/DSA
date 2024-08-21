class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

class Tuple{
    int stops;
    int node;
    int weight;
    Tuple(int stops, int node, int weight){
        this.stops = stops;
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        Queue<Tuple> que = new LinkedList<>();
        que.add(new Tuple(0, src, 0));
        
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0; 
        
        while(!que.isEmpty()){
            Tuple it = que.peek();
            que.remove();
            int stops = it.stops;
            int node = it.node;
            int weight = it.weight;
            
            if(stops > k) continue;
            
            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int edgeWeight = iter.weight;
                
                if(weight + edgeWeight < dist[adjNode] && stops <= k){
                    dist[adjNode] = weight + edgeWeight;
                    que.add(new Tuple(stops + 1, adjNode, weight + edgeWeight));
                }
            }
        }
        
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}