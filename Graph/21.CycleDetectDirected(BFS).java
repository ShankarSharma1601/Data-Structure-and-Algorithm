// Cycle Detection in Directed Graph
// BFS Appraoch(Kahn's Algorithm)
// Time Complexity : O(V + E)
// Space Complexity : O(V)

class Solution{
    public boolean isCyclic(int V , ArrayList<ArrayList<Integer>> adj){

        Queue<Integer> queue = new LinkedList<>();
        int indegree[] = new int[V];
        for(int i = 0;i < V;i++){
            for(Integer nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }

        for(int i = 0;i < V;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }

        if(count == V) return false;
        return true;
    }
}