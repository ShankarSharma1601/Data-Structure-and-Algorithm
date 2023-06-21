// Capacity to Ship Packages Within D days
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0 , maxLoad = 0;
        for(int weight : weights){
            totalLoad += weight;
            maxLoad = Math.max(maxLoad , weight);
        }

        int low = maxLoad , high = totalLoad;

        while(low < high){
            int mid = low + (high - low ) / 2;
            if(isPossible(weights , mid , days)){
                high = mid;
            }
            else low = mid + 1;
        }

        return low;
    }
    private boolean isPossible(int weights[] , int capacity , int day){
        int daysNeeded = 1 , currLoad = 0;
        for(int weight : weights){
            currLoad += weight;
            if(currLoad > capacity){
                daysNeeded++;
                currLoad = weight;
            }
        }
        return daysNeeded <= day;
    }
}