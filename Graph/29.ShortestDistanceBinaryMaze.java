// Shortest Distance in a Binary Maze
// Time Complexity : O(4*M*N)
// Space Complexity : O(M*N)


// DFS Approach
class Solution {
    int ans = Integer.MAX_VALUE;
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        solve(grid , source[0] , source[1] , destination[0] , destination[1] , 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private void solve(int grid[][] , int sx , int sy ,int dx ,int dy , int path){
        if(sx < 0 || sy < 0 || sx >= grid.length || sy >= grid[0].length || grid[sx][sy] == 0) return ;
        if(sx == dx && sy == dy){
            ans = Math.min(ans , path);
        }
        
        grid[sx][sy] = 0;
        solve(grid , sx + 1 , sy , dx , dy , path + 1);
        solve(grid , sx , sy + 1 , dx , dy , path + 1);
        solve(grid , sx , sy - 1 , dx , dy , path + 1);
        solve(grid , sx - 1 , sy , dx , dy , path + 1);
        
        grid[sx][sy] = 1;
        
    }
}


// BFS Approach
class Solution{
    int shortestPath(int[][] grid, int[] source, int[] destination){
        Queue<pair> queue = new LinkedList<>();
        int dx[] = {1 , 0 , -1 , 0};
        int dy[] = {0 , 1 , 0 , -1};
        queue.add(new pair(source[0] , source[1]));
        int ans = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0;i < n;i++){
                pair p = queue.poll();
                grid[p.x][p.y] = -1;
                if(p.x == destination[0] && p.y == destination[1]){
                    return ans;
                }
                for(int j = 0;j < 4;j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(isValid(nx , ny , grid)){
                        grid[nx][ny] = -1;
                        queue.add(new pair(nx , ny));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
    private boolean isValid(int x , int y , int grid[][]){
        int n = grid.length;
        int m = grid[0].length;
        return x >= 0  && y >= 0 && x < n && y < m && grid[x][y] == 1;
    }
}
class pair{
    int x , y;
    pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}