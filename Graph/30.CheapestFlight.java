// Cheapest Flights Within K Stops
// Time Complexity : O(N)  Where N = Number of flights / Number of edges.
// Space Complexity : O(|E| + |V|)  Where E = Number of edges (flights.length()) and V = Number of Airports.


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            //u ----> v 
            adj.get(u).add(new pair(v , wt));
        }
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0 , src , 0));  // stops , node , cost
        int dist[] = new int[n];
        Arrays.fill(dist , (int)1e9);
        dist[src] = 0;
        
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int stops = tuple.first;
            int node = tuple.second;
            int cost = tuple.third;
            
            if(stops > k) continue;
            for(pair p : adj.get(node)){
                int adjNode = p.first;
                int weight = p.second;
                if(cost + weight < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + weight;
                    queue.add(new Tuple(stops + 1 , adjNode , cost + weight));
                }
            }
        }
        
        
        if(dist[dst] == (int)1e9) return -1;
        else return dist[dst];
    }
}

class pair{
    int first , second;
    pair(int fir , int sec){
        first = fir;
        second = sec;
    }
}

class Tuple{
    int first , second , third;
    Tuple(int fir , int sec , int third){
        first = fir;
        second = sec;
        this.third = third;
    }
}