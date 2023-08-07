// Word Search 
// Time Complexity : O(m*n*4^k), where K is the length of the word.
// Space Complexity : O(k)

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0) return false;
        
        char ch = word.charAt(0);
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j] == ch){
                    if(solve(board , i , j , board.length , board[i].length , word , 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean solve(char b[][] , int row , int col , int n , int m , String word , int ind){
        if(ind >= word.length()) return true;
        if(row < 0 || col < 0 || row >= n || col >= m || b[row][col] == '.' || b[row][col] != word.charAt(ind)) return false;
        
        char ch = b[row][col];
        b[row][col] = '.';
        
        boolean ans = solve(b , row + 1 , col , n , m , word , ind + 1) || 
            solve(b , row , col + 1 , n , m , word , ind + 1) ||
            solve(b , row , col - 1 , n , m , word , ind + 1) ||
            solve(b , row - 1 , col , n , m , word , ind + 1);
        
        b[row][col] = ch;
        return ans;
    }
}