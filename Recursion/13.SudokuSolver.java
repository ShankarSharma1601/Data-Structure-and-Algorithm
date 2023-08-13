// Sodoku Solver
// Time Complexity : O(9(n ^ 2)), in the worst case, for each cell in the n^2 board, we have 9 possible numbers.
// Space Complexity : O(1)


class Solution {
    
    public boolean isSafe(char [][]board, int row, int col,int number){
        //for row & col
        for(int i = 0;i < board.length;i++){
            if(board[i][col] == (char)(number + '0')){
                return false;
            }
            if(board[row][i] == (char)(number + '0')){
                return false;
            }
        }
        
        //grid
        int start_row = row/3 *3;
        int start_col = col/3 *3;
        for(int i = start_row;i < start_row + 3;i++){
            for(int j = start_col; j < start_col + 3;j++){
                if( board[i][j] == (char)(number + '0') ){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    public boolean helper(char [][] board, int row, int col){
        if(row == board.length){
            return true;
        }
        
        int new_row = 0;
        int new_col = 0;
        if( col != board.length - 1 ){
            new_row = row;
            new_col = col + 1;
        }
        else{
            new_row = row + 1;
            new_col = 0;
        }
        if(board[row][col] != '.'){
            if( helper(board, new_row, new_col) ) return true;
        }
        else{
            for(int i = 1; i <= 9; i++){
                if(isSafe(board, row, col, i)){
                    board[row][col] = (char)(i + '0');
                    if( helper(board, new_row, new_col)){
                        return true;
                    }
                    else board[row][col] = '.';
                }
            }
        }
        return false;
        
    }
    
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}

