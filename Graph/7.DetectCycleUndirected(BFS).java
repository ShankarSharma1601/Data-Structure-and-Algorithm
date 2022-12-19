// Detect Cycle in an Undirected Graph
// BFS Approach

class Solution {
   
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V+1];
        for(int i = 0;i < V;i++){
            if(vis[i] == 0){
                if( bfs(i , adj , vis) ){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int src , ArrayList<ArrayList<Integer>> adj , int vis[]){
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(src , -1));
        vis[src] = 1;

        while(!queue.isEmpty()){
            pair p = queue.poll();
            int node = p.node;
            int par = p.par;
            for(Integer nbr : adj.get(node)){
                if(vis[nbr] == 0){
                    vis[nbr] = 1;
                    queue.add(new pair(nbr , node));
                }
                else if(nbr != par) return true;
            }
        }
        return false;
    }

}

class pair{
    int node;
    int par;
    pair(int node , int par){
        this.node = node;
        this.par = par;
    }
}