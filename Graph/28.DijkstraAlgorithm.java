// Implementing Dijkstra Algorithm
// Time Complexity : O(ElogV)
// Space Complexity : O(E + V)

class Solution{
    //Function to find the shortest distance of all the vertices
    //from the source vertex Source.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int Source){
       int ans[] = new int[V];
       Arrays.fill(ans , Integer.MAX_VALUE);

       PriorityQueue<Integer> queue = new PriorityQueue<>();
       ans[Source] = 0;
       queue.add(Source);
       
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(ArrayList<Integer> nbr : adj.get(node)){
                if(ans[node] + nbr.get(1) < ans[nbr.get(0)]){
                   ans[nbr.get(0)] = ans[node] + nbr.get(1);
                   queue.add(nbr.get(0));
                }
            }
        }
       return ans;
    }
}
