// Path with Minimum Effort
// Time Complexity :  O( 4*N*M * log( N*M) ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the minimum effort and additional log(N*M) for insertion-deletion operations in a priority queue } 
// Space Complexity :  O( N*M ) { Distance matrix containing N*M cells + priority queue in the worst case containing all the nodes ( N*M) }.



class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length , m = heights[0].length;
         int dist[][] = new int[n][m];
        for(int i = 0;i < n;i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0] );
        pq.add(new int[]{0 , 0 , 0}); // effort, row, col
        
        int dr[] = {-1 , 0 , 1 , 0};
        int dc[] = {0 , 1 , 0 , -1};
        
        while(!pq.isEmpty()){
            int []temp = pq.poll();
            int effort = temp[0];
            int row = temp[1];
            int col = temp[2];
            if(row == n-1 && col == m-1) return effort;
            for(int i = 0;i < 4;i++){
                int new_row = row + dr[i];
                int new_col = col + dc[i];
                if(new_row >=0 && new_row < n && new_col >= 0 && new_col < m){
                    int newEffort = Math.max(effort , Math.abs(heights[row][col] - heights[new_row][new_col]));
                    if(dist[new_row][new_col] > newEffort){
                        dist[new_row][new_col] = newEffort;
                        pq.add(new int[]{newEffort , new_row , new_col});
                    }
                }
            }
        }
        return 0;
    }
}