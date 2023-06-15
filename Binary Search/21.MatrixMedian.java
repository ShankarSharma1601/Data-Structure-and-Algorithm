// Matrix Median
// Median in a row-wise sorted Matrix
// Using Binary Search
// Time Complexity : O(n*logm)
// Space Complexity : O(1)

class Solution{
    int median(int matrix[][] , int row , int col){
        int low = 1;
        int high = 1000000000;
        int n = row;
        int m = col;

        while(low <= high){
            int mid = (low + high) >> 1;
            int count = 0;
            for(int i = 0;i < n;i++){
                count += countSmallerThanMid(matrix[i] , mid , col);
            }

            if(count <= (n*m)/2){
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }
    private int countSmallerThanMid(int arr[] , int mid , int n){
        int low = 0 , high = n - 1;

        while(low <= high){
            int md = (low + high) >> 1;
            if(arr[md] <= mid){
                low = md + 1;
            }
            else high = md - 1;
        }

        return low;
    }
}


// Another Approach
// Time Complexity : O(n*mlog(n*m))
// Space Complexity : O(n*m)


class Solution {
    int median(int matrix[][], int r, int c) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                arr.add(matrix[i][j]);
            }
        }
        Collections.sort(arr);
        if(arr.size()%2 !=0){
            return arr.get(arr.size()/2);
        }
        else{
            int n = arr.size();
            return arr.get(n/2)+arr.get(n+1/2) / 2;
        }
              
    }
}