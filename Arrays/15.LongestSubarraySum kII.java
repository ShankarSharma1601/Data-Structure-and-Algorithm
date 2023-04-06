// Longest SubArray with Given Sum K
// Both positive and negative Element are present in array

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    public static int longestSubArray(int nums[] , int n , int k){
        HashMap<Integer , Integer> map = new HashMap<>();

        int sum = 0 , ans = 0;
        map.put(0 , -1);
        for(int i = 0;i < nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                ans = Math.max(ans , i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){
                map.put(sum , i);
            }
        }
        return ans;
    }
}