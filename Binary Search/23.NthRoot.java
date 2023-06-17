// Nth root of a number using binary search
// Time Complexity : O(nlogm)
// Space Complexity : O(1)


class Solution{
    public int NthRoot(int n, int m){
        int low = 1 , high = m;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(Math.pow(mid , n) == m) return mid;
            else if(Math.pow(mid , n) > m) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}


// Alternate Solution
class Solution {
    public static void getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-7; 
        
        while((high - low) > eps) {
            double mid = (low + high) / 2.0; 
            if(multiply(mid, n) < m) {
                low = mid; 
            }
            else {
                high = mid; 
            }
        }
        
        System.out.println(n+"th root of "+m+" is "+low);  
        
    }
    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans; 
    }
}