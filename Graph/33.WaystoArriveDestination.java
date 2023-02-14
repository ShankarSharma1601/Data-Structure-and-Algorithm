// Number of ways to Arrive at Destination
// Time Complexity : O( E* log(V)) 
// Space Complexity : (N)
// Where E = Number of edges , V = No. of vertices and  N = Number of nodes.



class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i < roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            
            //u ---> v;
            adj.get(u).add(new pair(v , wt));
            //v --> u
            adj.get(v).add(new pair(u , wt));
        }
        
        // Defining a priority queue (min heap).
        PriorityQueue<pair> queue = new PriorityQueue<>((x , y) -> x.first - y.first);
        queue.add(new pair(0 , 0)); // dist , node
        
        int dist[] = new int[n];
        int ways[] = new int[n];
        
        Arrays.fill(dist , (int)1e9);
        Arrays.fill(ways , 0);
        
        dist[0] = 0;
        ways[0] = 1;
        
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int node = p.second;
            int dis = p.first;
            
            for(pair nbr : adj.get(node)){
                int adjNode = nbr.first;
                int weight = nbr.second;
                if(dis + weight < dist[adjNode]){
                    dist[adjNode] = dis + weight;
                    queue.add(new pair(dis + weight , adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dist[adjNode] == dis + weight){
                    ways[adjNode] = (ways[adjNode]  + ways[node] ) % (int)1e9+7;
                }
            }
        }
        return ways[n-1] % (int)1e9+7;
    }
}

class pair{
    int first , second;
    pair(int fir , int sec){
        first = fir;
        second = sec;
    }
}