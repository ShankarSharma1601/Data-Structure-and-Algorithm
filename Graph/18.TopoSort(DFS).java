// TopoSort 
// DFS Approach
// Time Complexity : O(V + E)
// Space Complexity : O(V)

class Solution{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new int[V];

        for(int i = 0;i <V;i++){
            if(vis[i] == false){
                dfs(adj , stack , i , vis);
            }
        }

        int ans[] = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            ans[index++] = stack.pop();
        }
        return ans;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj , Stack<Integer> stack , int node , boolean vis[]){
        vis[node] = true;
        for(Integer nbr : adj.get(node)){
            if(vis[nbr] == false){
                dfs(adj , stack , nbr , vis);
            }
        }
        stack.push(node);
    }
}