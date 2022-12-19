//DFS traversal
//time complexity -- O(N + E)
//space complexity -- O(N + E) + O(N) + O(N)

class solution{
    ArrayList<Integer> dfsofgraph(int vertex , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean vis[] = new boolean[vertex + 1];

        for(int i = 1; i <= vertex; i++){
            if(vis[i] == false){
                dfs(i , vis , adj , storeDfs);
            }
        }
        return storeDfs;
    }

    void dfs(int node , boolean vis[] ,ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> storeDfs ){
        storeDfs.add(node);
        vis[node] = true;

        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(it , vis , adj , storeDfs);
            }
        }
    }
}