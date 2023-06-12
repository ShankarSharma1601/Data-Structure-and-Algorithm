// search a 2D Matrix II
// Here Integers in each row are sorted from left to right
// & Integers in each column are sorted from top to bottom
// Time Complexity : O(n + m)
// Space Complexity : O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}