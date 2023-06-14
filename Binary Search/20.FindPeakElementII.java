// Peak Element II
// Time Complexity : O(nlogm)
// Space Complexity : O(1)

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        while(low <= high){
            int maxRow = 0;
            int midCol = (low + high) >> 1;
            for(int row = 0; row < n; row++){
                if(mat[row][midCol] > mat[maxRow][midCol]){
                    maxRow = row;
                }
            }
            int currElement =  mat[maxRow][midCol];
            int leftElement = midCol == 0 ? -1 : mat[maxRow][midCol-1];
            int rightElement = midCol == m-1 ? -1 : mat[maxRow][midCol+1];
            if(currElement > leftElement && currElement > rightElement){
                return new int[]{maxRow, midCol};
            }
            else if(currElement < leftElement){
                high = midCol - 1;
            }
            else{
                low = midCol + 1;
            }
        }
        return new int[]{-1, -1};
    }
}