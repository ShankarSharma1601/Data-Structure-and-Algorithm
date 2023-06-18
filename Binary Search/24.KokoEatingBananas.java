// Koko Eating Bananas
// Time Complexity : O(nlogn)
// Space Complexity : O(1)


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 , high = (int)1e9;
        while(low < high){
            int mid = low + ( high - low)/2;
            if(ok(piles , mid , h)) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    private boolean ok(int piles[] , int mid , int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile + mid - 1)/mid;
        }
        return hours > h;
    }
}