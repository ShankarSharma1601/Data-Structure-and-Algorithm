// Network Delay Time
// Time Complexity : O(N*E)
// Space Complexity : O(N*E)
// Where N is the number of nodes and E is the number of total edges in the given network.


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        n = n + 1;
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i < times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int wt = times[i][2];
            
            // u ------> v
            adj.get(u).add(new pair(v , wt));
        }
        
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(k , 0));
        
        int dist[] = new int[n];
        Arrays.fill(dist , (int)1e9);
        dist[k] = 0;
        
        
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int node = p.first;
            int cost = p.second;
            
            for(pair nbr : adj.get(node)){
                int adjNode = nbr.first;
                int weight = nbr.second;
                
                if(cost + weight < dist[adjNode]){
                    dist[adjNode] = cost + weight;
                    queue.add(new pair(adjNode , cost + weight));
                }
            }
        }
        
        int max = dist[1];
        for(int i = 1;i < n;i++){
            if(dist[i] == (int)1e9 ) return -1;
            max = Math.max(max , dist[i]) ;
        }
        
        return max;
    }
}

class pair{
    int first , second;
    pair(int fir , int sec){
        first = fir;
        second = sec;
    }
}