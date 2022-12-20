// 0/1 Matrix
// Distance of nearest cell having 1

class Solution{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        int ans[][] = new int[n][m];
        int vis[][] = new int[n][m];
        
        Queue<pair> queue = new LinkedList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    queue.add(new pair(i , j , 0));
                    vis[i][j] = 1;
                }
            }
        }
        
        int r[] = {-1 , 0 , 1 , 0};
        int c[] = {0 , 1 , 0 , -1};
        
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            
            ans[row][col] = dist;
            
            for(int i = 0;i < 4;i++){
                int new_row = row + r[i];
                int new_col = col + c[i];
                if(new_row >= 0 && new_col >= 0 && new_row < n && new_col < m && vis[new_row][new_col] == 0){
                    vis[new_row][new_col] = 1;
                    queue.add(new pair(new_row , new_col , dist + 1));
                }
            }
        }
        
        return ans;
    }
}

class pair{
    int row;
    int col;
    int dist;
    pair(int fir , int sec , int dist){
        row = fir;
        col = sec;
        this.dist = dist;
    }
}