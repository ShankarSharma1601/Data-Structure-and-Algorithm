// N Queen
// Time Complexity : O(N! * N)
// Space Complexity : O(N)

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i < n;i ++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        dfs(board , 0 , ans);
        return ans;
        
    }
    
    private void dfs(char board[][] , int colIndex , List<List<String>> ans){
        
        //base condition
        if(colIndex == board.length){
            ans.add(construct(board));
            return;
        }
        
        
        for(int i = 0 ; i < board.length ; i ++){
            if( isValidate(board , i , colIndex)){
                board[i][colIndex] = 'Q';
                dfs(board , colIndex+1 , ans);
                board[i][colIndex] = '.';
            }
        }
        
    }
    
    private boolean isValidate(char board[][] , int x , int y){
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j < y;j++){
                if( board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i) ){
                    return false;
                }
            }   
        }
        return true;
    }
    
    private List<String> construct(char board[][]){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < board.length;i++){
            String str = new String(board[i]);
            res.add(str);
        }
        return res;
    }
    
    
}
