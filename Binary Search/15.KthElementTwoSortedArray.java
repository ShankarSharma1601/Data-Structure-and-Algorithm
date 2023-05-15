// Kth Element of Two Sorted Array
// Time Complexity : O(k)
// Space Complexity : O(1)

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i = 0 , j = 0;
        while(--k > 0){
            if(i < n && j < m){
                if(arr1[i] < arr2[j]) i++;
                else j++;
            }
            else{
                if(i < n) i++;
                else j++;
            }
        }
        
        if(i < n && j < m) return Math.min(arr1[i] , arr2[j]);
        else{
            if(i < n) return arr1[i];
            else return arr2[j];
        }
    }
}