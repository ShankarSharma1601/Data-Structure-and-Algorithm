// Bipartite Graph 
// DFS approach

class Solution{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
       int color[] = new int[V];
       Arrays.fill(color , -1);
       
       for(int i = 0;i < V;i++){
           if(color[i] == -1){
               if(!dfs(adj , i , color)){
                   return false;
               }
           }
       }
       return true;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>>adj , int node , int color[]){
        if(color[node] == -1) color[node] = 1;
        for(Integer nbr : adj.get(node)){
            if(color[nbr] == -1){
                color[nbr] = 1 - color[node];
                if(!dfs(adj , nbr , color)) return false;
            }
            else if(color[nbr] == color[node]) return false;
        }
        return true;
    }
}