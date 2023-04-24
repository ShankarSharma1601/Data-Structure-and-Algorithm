// Count number of subarray with given xor K
// Recursion Solution

class Solution{
    static int subsetXOR(int arr[], int n, int k) {
         return solve(arr , k , 0 , 0);
    }
    private static int solve(int arr[] , int target , int xor , int index){
        if(index == arr.length){
            if(target == xor) return 1;
            return 0;
        }
        
        int ans = 0;
        ans += solve(arr , target , xor ^ arr[index] , index + 1) + solve(arr , target , xor , index + 1);
        return ans;
    }
}


// Alternate Solution
// DP Solution

class Solution{
    static int subsetXOR(int arr[], int n, int k) {
        int max_ele = arr[0];
     
        for(int i = 1; i < n; i++)
          if (arr[i] > max_ele)
            max_ele = arr[i];
            
        int m = (1 << (int)(Math.log(max_ele) / Math.log(2) + 1) ) - 1;
        if (k > m){
           return 0;  
        }
    
        int [][]dp = new int[n + 1][m + 1];
    
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++)
            for(int j = 0; j <= m; j++)
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j ^ arr[i - 1]];
                
        return dp[n][k];
    }
}