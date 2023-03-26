// Second Largest Element in an Array
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    int print2ndlargest(int arr[], int n) {
        if(n == 1) return -1;
        int first = Integer.MIN_VALUE;
        int sec = -1;
        
        for(int val : arr){
            first = Math.max(first , val);
        }
        
        for(int val : arr){
            if(val != first){
                sec = Math.max(sec , val);
            }
        }
        return sec;
    }
}