// Detect cycle in an undirected graph
// DFS Approach


class Solution {
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V+1];
        for(int i = 0;i < V;i++){
            if(vis[i] == 0){
                if(dfs(i , -1 ,  adj , vis)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node , int par , ArrayList<ArrayList<Integer>> adj , int vis[]){
        vis[node] = 1;
        for(Integer nbr : adj.get(node)){
            if(vis[nbr] == 0){
                if(dfs(nbr , node , adj , vis)){
                    return true;
                }
            }
            else if(nbr != par) return true;
        }
        return false;
    }

}

