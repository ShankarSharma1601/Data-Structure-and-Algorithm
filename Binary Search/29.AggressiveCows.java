// Aggressive Cows
// Time Complexity : O(nlogn)
// Space Complexity : O(1)


class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int ans = -1;
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            min = Math.min(min , stalls[i]);
            max = Math.max(max, stalls[i]);
        }
        
        int low = 0 , high = max - min;
        int mid = 0;
        while(low <= high){
            mid = low + ( high - low ) / 2;
            if(isValidDistance(stalls , n , k , mid)){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        
        return ans;
    }
    
    private static boolean isValidDistance(int stalls[] , int n , int cow , int mid){
        int cowCount = 1 , position = stalls[0];
        for(int i = 1;i < n;i++){
            if(stalls[i] - position >= mid){
                cowCount++;
                if(cowCount == cow) return true;
                position = stalls[i];
            }
        }
        return false;
    }
}