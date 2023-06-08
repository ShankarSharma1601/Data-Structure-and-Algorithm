// Search in a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0 , col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}


// binary search approach
// Time Complexity : O(log(n*m))
// Space Complexity : O(1)

class Solution{
    public boolean searchMatrix(int matrix[][] , int target){
        if(matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n * m) - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][m][mid%m] == target){
                return true;
            }
            if(matrix[mid][m][mid%m] < target){
                low = mid + 1;
            }
            else high = mid - 1;
        }

        return false;
    }
}