// Shortest Path in DAG
// Time Complexity: O(N+M) {for the topological sort} + O(N+M) {for relaxation of vertices, each node and its adjacent nodes get traversed} ~ O(N+M).
// Space Complexity:  O(N) {for the stack storing the topological sort} + O(N) {for storing the shortest distance for each node} + O(N) {for the visited array} + O( N+2M) {for the adjacency list} ~ O(N+M) .
// Where N = number of vertices and M = number of edges.


class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		
		ArrayList<ArrayList<pair>> adj = new ArrayList<>();
		for(int i = 0; i < N;i++){
		    adj.add(new ArrayList<pair>());
		}
		
		for(int i = 0;i < M;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new pair(v , wt));
		}
		
		Stack<Integer> stack = new Stack<>();
		int vis[] = new int[N];
		for(int i = 0;i < N;i++){
		    if(vis[i] == 0){
		        topo(adj , i , vis , stack);
		    }
		}
		
		int dist[] = new int[N];
		Arrays.fill(dist , (int)1e9);
		dist[0] = 0;
		
		while(!stack.isEmpty()){
		    int node = stack.pop();
		    for(int i = 0;i < adj.get(node).size();i++){
		        int nbr = adj.get(node).get(i).first;
		        int wt = adj.get(node).get(i).second;
		        if(dist[node] + wt < dist[nbr]){
		            dist[nbr] = dist[node] + wt;
		        }
		    }
		}
		
		for(int i = 0;i < N;i++){
		    if(dist[i] == (int)1e9) dist[i] = -1;
		}
		return dist;
		
	}
	private void topo(ArrayList<ArrayList<pair>> adj , int node , int vis[] , Stack<Integer> stack){
	    vis[node] = 1;
	    for(int i = 0;i < adj.get(node).size();i++){
	        int v = adj.get(node).get(i).first;
	        if(vis[v] == 0){
	            topo(adj , v , vis , stack);
	        }
	    }
	    stack.push(node);
	}
}

class pair{
    int first , second;
    pair(int fir , int sec){
        first = fir;
        second = sec;
    }
}
