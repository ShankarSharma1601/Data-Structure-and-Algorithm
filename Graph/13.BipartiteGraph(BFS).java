// Bipartite Graph
// BFS Approach

class Solution{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
        
        int color[] = new int[V];
        Arrays.fill(color , -1);
        
        for(int i = 0; i < V;i++){
            if(color[i] == -1){
                if(!bfs(i , adj , color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(int src ,ArrayList<ArrayList<Integer>>adj , int color[] ){
        color[src] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer nbr : adj.get(node)){
                if(color[nbr] == -1){
                    color[nbr] = 1 - color[node];
                    queue.add(nbr);
                }
                else if(color[nbr] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}