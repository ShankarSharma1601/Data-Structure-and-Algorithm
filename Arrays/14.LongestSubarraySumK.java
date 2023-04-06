// Longest SubArray with Given Sum K
// Only positive Element in an array

// Brute Force
// Time Complexity : O(n^2)
// Space Complexity : O(1)

class Solution{
    public static int longestSubArray(int arr[] , int n , int k){
        int maxLength = 0;
        for(int i = 0;i < n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[i];
                if(sum == k){
                    maxLength = Math.max(maxLength , j - i + 1);
                }
            }
        }
        return maxLength;
    }
}

// Sliding Window Technique
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    public static int longestSubArray(int arr[] , int n , int k){
        int start = 0;
        int end = -1;
        int sum = 0;
        int maxLength = 0;

        while(start < n){
            while((end + 1 < n) && (sum + arr[end + 1] <= k)){
                sum += arr[++end];
            }

            if(sum == k){
                maxLength = Math.max(maxLength , end - start + 1);
            }

            sum -= arr[start];
            start++;
        }
        return maxLength;
    }
}