// Row with max 1s
// Time Complexity : O(nlogm)
// Space Complexity : O(1)

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int max = Integer.MIN_VALUE;
        int k = -1;
        for(int i = 0;i < n;i++){
            int low = 0 , high = m - 1;
            int ans = m;
            while(low <= high){
                int mid = low + ( high - low) / 2;
                if(arr[i][mid] == 1){
                    ans = mid;
                    high = mid - 1;
                }
                else low = mid + 1;
            }
            if(m - ans > max){
                max = m - ans;
                if(m - ans != 0){
                    k = i;
                }
            }
        }
        return k;
    }
}