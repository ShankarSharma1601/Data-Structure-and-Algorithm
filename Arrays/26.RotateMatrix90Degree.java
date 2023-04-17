// Rotate Matrix by 90 Degree
// Time Complexity : O(n*n) --> O(n^2)
// Space Complexity : O(1)

class Solution {
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
        mirrorImage(matrix);
        
    }
    private void transpose(int [][]matrix){
        int n = matrix.length;
        for(int i = 0;i < n ; i++){
            for(int j = i+1;j < n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void mirrorImage(int [][]matrix){
        int n = matrix.length;
        for(int i = 0;i < n; i++){
            for(int j  = 0;j < n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}