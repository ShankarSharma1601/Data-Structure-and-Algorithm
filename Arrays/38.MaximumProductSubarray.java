// Maximum Product Subarray
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int maxProduct(int[] arr) {
        //single pass;
        int ans = arr[0];
        int max = arr[0];
        int min = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(arr[i] < 0){
                //swap min and max
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i] , max * arr[i]);
            min = Math.min(arr[i] , min * arr[i]);
            ans = Math.max(ans , max);
        }
        return ans;
    }
}


// Alternate Solution
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    public int maxProduct(int arr[]){
        int maxp = Integer.MIN_VALUE , prod = 1;
        for(int i = 0;i < arr.length;i++){
            prod *= arr[i];
            maxp = Math.max(maxp , prod);
            if(prod == 0) prod = 1;
        }
        prod = 1;
        for(int i = arr.length - 1;i >= 0;i--){
            prod *= arr[i];
            maxp = Math.max(maxp , prod);
            if(prod == 0) prod = 1;
        }
        return maxp;
    }
}