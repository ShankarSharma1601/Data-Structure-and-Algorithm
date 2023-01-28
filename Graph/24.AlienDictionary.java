// Alien Dictionary
// Time Complexity : O(N*len)+O(K+E) where N is the number of words in the dictionary, ‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
// Space Complexity : O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure used in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.


class Solution{
    public String findOrder(String [] dict, int N, int K){
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < K;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i < N-1;i++){
            String str1 = dict[i];
            String str2 = dict[i+1];
            int len = Math.min(str1.length() , str2.length());
            for(int j = 0;j < len;j++){
                if(str1.charAt(j) != str2.charAt(j)){
                    adj.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topoSort(K , adj);
        String ans = "";
        for(Integer val : topo){
            ans += (char)(val + (int)('a'));
        }
        return ans;
    }
    private List<Integer> topoSort(int V , List<List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        int indegree[] = new int[V];
        for(int i = 0;i < V;i++){
            for(Integer nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        
        for(int i = 0;i < V;i++){
            if(indegree[i] == 0) queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0) queue.add(nbr);
            }
        }
        
        return ans;
    }
}