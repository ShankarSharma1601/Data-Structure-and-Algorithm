//bfs traversal 
//time complexity -- O(N + E)
//space complexity -- O(N + E) + O(N) + O(N)
//N is time taken for visiting n nodes 
//E is for travelling through adjacency nodes
//space for adjacency list , visited array , queue

class solution{
    ArrayList<Integer> bfsTraversal(int vertex , ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[vertex+1];

        for(int i = 1 ; i <= vertex; i++){
            if(vis[i] == false){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                vis[i] = true;
                while( !queue.isEmpty()){
                    int node = queue.poll();
                    bfs.add(node);
                    for(Integer it : adj.get(node)){
                        if(vis[it] == false){
                            queue.add(it);
                            vis[it] = true;
                        }
                    }
                }
            }
        }
        return bfs;
    }
}