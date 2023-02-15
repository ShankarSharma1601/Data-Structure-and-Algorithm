// Minimum Multiplications to reach End
// Time Complexity : O(100000 * N) 
// Space Complexity : O(100000 * N) 


class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(start , 0));
        
        int dist[] = new int[100000];
        Arrays.fill(dist , (int)1e9);
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int node = p.first;
            int steps = p.second;
            
            for(int i = 0;i < arr.length;i++){
                int adjNode = node * arr[i];
                adjNode = adjNode % 100000;
                
                if(steps + 1 < dist[adjNode]){
                    dist[adjNode] = steps + 1;
                    if(adjNode == end) return steps + 1;
                    queue.add(new pair(adjNode , steps + 1));
                }
            }
        }
        
        return -1;
    }
}

class pair{
    int first ,  second;
    pair(int fir , int sec){
        first = fir;
        second = sec;
    }
}
