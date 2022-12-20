// Detect cycle in an Directed Graph
// DFS Approach




class Solution {
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        boolean visited[] = new boolean[V];
        boolean dfsvis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i] == false){
                if(checkforcycle(i, adj, visited,dfsvis) ){
                    return true;
                } 
            }
        }
        return false;
    }

    private boolean checkforcycle(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited , boolean[] dfsvis){
        
        visited[node]= true; dfsvis[node]= true;
        for( Integer it : adj.get(node) ){
            if(visited[it] ==false){
                 if(checkforcycle(it, adj, visited,dfsvis) ){
                    return true;
                } 
            }
            else if(dfsvis[it]==true) return true;
        }
        dfsvis[node]=false;
        return false;
        
    }
}