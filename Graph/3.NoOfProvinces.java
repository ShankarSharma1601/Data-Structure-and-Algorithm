class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        
        int ans = 0;
        boolean vis[] = new boolean[V];
        for(int i = 0;i < V;i++){
            if(vis[i] == false){
                dfs(adj , i , vis , V);
                ans++;
            }
        }
        return ans;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj , int node , boolean vis[] , int V){
        vis[node] = true;
        for(int i = 0;i < V;i++){
            if(vis[i] == false && adj.get(node).get(i) == 1) dfs(adj , i , vis , V);
        }
    }
};