// Floor in a Sorted Array
// Lower bound of any value
// Time Complexity : O(logn)
// Space Complexity : O(1)



class Solution{
    static int findFloor(long arr[], int n, long x){
        int start = 0 , end = n - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] <= x){
                ans = mid;
                start = mid + 1;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }
        }
        return ans;
    }
}