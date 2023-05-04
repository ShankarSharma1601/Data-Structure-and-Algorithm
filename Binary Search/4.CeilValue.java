// Ceil in a sorted array
// Upper bound of any value
// Time Complexity : O(logn)
// Space Complexity : O(1)


class Solution{
    static int findCeil(long arr[], int n, long x){
        int start = 0 , end = n - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < x){
                start = mid + 1;
            }
            else if(arr[mid] >= x){
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
}