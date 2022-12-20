//DFS multisource

class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    ArrayList<Integer> temp = new ArrayList<>();
                    dfs(grid , i , j , i , j , n , m , temp);
                    set.add(temp);
                }
            }
        }
        return set.size();
    }
    private void dfs(int grid[][] , int row , int col , int r , int c , int n , int m , ArrayList<Integer> arr){
        if(row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == 0){
            return ;
        }
        
        grid[row][col] = 0;
        arr.add(row - r );
        arr.add(col - c);
        dfs(grid , row + 1 , col , r , c , n , m , arr);
        dfs(grid , row , col + 1 , r , c , n , m , arr);
        dfs(grid , row , col - 1 , r , c , n , m , arr);
        dfs(grid , row - 1 , col , r , c , n , m , arr);
    }
}

