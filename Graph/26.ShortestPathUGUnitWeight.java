// Shortest Path in Undirected Graph with unit distance
// Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’} + O(N + 2M) { for the BFS Algorithm} + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M). 
// Where N= number of vertices and M= number of edges.
// Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array} + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
// Where N= number of vertices and M= number of edges.


class Solution {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }

        for(int i = 0;i<m;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        } 

        int dist[] = new int[n];
        for(int i = 0;i<n;i++) dist[i] = (int)1e9;
        dist[src] = 0; 


        Queue<Integer> q = new LinkedList<>();
        q.add(src); 
        while(!q.isEmpty()) {
            int node = q.poll();  
            for(int nbr : adj.get(node)) {
                if(dist[node] + 1 < dist[nbr]) {
                    dist[nbr] = 1 + dist[node]; 
                    q.add(nbr); 
                }
            }
        } 
        
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1; 
            }
        }
        return dist; 
    }
}