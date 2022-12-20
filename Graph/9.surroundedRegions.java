// Surrounded Regions
// Replace O's with X's

class Solution {
    public char[][] solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0;i < m;i++){
            if(board[0][i] == 'O') dfs(board , 0 , i , n , m);
            if(board[n-1][i] == 'O') dfs(board , n-1 , i , n , m);
        }
        
        for(int i = 0;i < n;i++){
            if(board[i][0] == 'O') dfs(board , i , 0 , n , m);
            if(board[i][m-1] == 'O') dfs(board , i , m-1 , n , m);
        }
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
        return board;
    }
    private void dfs(char board[][] , int row , int col , int n , int m){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O'){
            return ;
        }
        
        board[row][col] = '#';
        dfs(board , row + 1 , col , n , m);
        dfs(board , row , col + 1 , n , m);
        dfs(board , row - 1 , col , n , m);
        dfs(board , row , col - 1 , n , m);
    }
}