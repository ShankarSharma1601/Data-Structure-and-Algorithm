class Solution{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid){
        
       int n = grid.length;
       int m = grid[0].length;
       int vis[][] = new int[n][m];
       Queue<pair> queue = new LinkedList<>();
       
       int fresh_count = 0;
       for(int i = 0;i < n;i++){
           for(int j = 0;j < m;j++){
               if(grid[i][j] == 2){
                   queue.add(new pair(i , j , 0));
                   vis[i][j] = 2;
               }
               else if(grid[i][j] == 1){
                   fresh_count++;
               }
           }
       }
       
       int row[] = {-1 , 0 , 1  , 0};
       int col[] = {0 , 1 , 0 , -1};
       int count = 0;
       int time = 0;
       
       while(!queue.isEmpty()){
           pair p = queue.poll();
           time = Math.max(time , p.time);
           
           for(int i = 0;i < 4;i++){
               int new_row = p.row + row[i];
               int new_col = p.col + col[i];
               
               if(new_row >= 0 && new_col >= 0 && new_row < n && new_col < m && vis[new_row][new_col] == 0 && grid[new_row][new_col] == 1){
                   queue.add(new pair(new_row ,  new_col , p.time + 1));
                   vis[new_row][new_col] = 2;
                   count++;
               }
           }
       }
       
       if(fresh_count != count) return -1;
       return time;
       
    }
}

class pair{
    int row;
    int col;
    int time;
    pair(int r , int c, int t){
        row = r;
        col = c;
        time = t;
    }
}