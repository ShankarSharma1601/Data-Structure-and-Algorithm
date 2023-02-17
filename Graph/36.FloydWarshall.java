// Floyd Warshall
// Time Complexity : O(V^3)
// Space Complexity :  O(V^2) 


class Solution{
    public void shortest_distance(int[][] matrix){
       int n = matrix.length;
       for(int k = 0;k < n;k++){
           for(int j = 0;j < n;j++){
               for(int i = 0;i < n;i++){
                   if(matrix[i][k] == -1 || matrix[k][j] == -1) continue;
                   if(matrix[i][j] == -1 || matrix[i][j] > matrix[i][k] + matrix[k][j]){
                       matrix[i][j] = matrix[i][k] + matrix[k][j];
                   }
               }
           }
       }
    }
}

// Alternate Solution
class Solution {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}