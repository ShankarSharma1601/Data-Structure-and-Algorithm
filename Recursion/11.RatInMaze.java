// Rat in a maze
// Time Complexity : O(4^(m*n)), because on every cell we need to try 4 different directions.
// Space Complexity : O(m*n), Maximum Depth of the recursion tree(auxiliary space).


class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> ans = new ArrayList<>();
        String path = "";
        helper(0 , 0 , n , m , path , ans );
        return ans;
        
    }
    
    private static void helper(int i , int j , int n , int [][]m , String path , ArrayList<String> ans){
        
        if( i < 0 || j < 0 || i == n || j == n || m[i][j] == 0){
            return;
        }
        else if( i == n-1 && j == n-1){
            ans.add(path);
        }
        else{
            m[i][j] = 0;
            //down
            helper(i+1 , j , n , m , path + 'D' , ans);
            //left
            helper(i , j-1 , n , m , path + 'L' , ans);
            //right
            helper(i , j+1 , n , m , path + 'R' , ans);
            //up
            helper(i-1 , j , n , m, path + 'U' , ans);
            
            m[i][j] = 1;
        }
    }
}

