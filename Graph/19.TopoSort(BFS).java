// TopoSort
// BFS Approach(Kahn's Algorithm)
// Time Complexity : O(V + E)
// Space Complexity : O(V) 

class Solution{
    static int[] topoSort(int V , ArrayList<ArrayList<Integer>>adj){
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

        int ans[] = new int[V];
        int index = 0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            ans[index++] = node;
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }

        return ans;
    }
}