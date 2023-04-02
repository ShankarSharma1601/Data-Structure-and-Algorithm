// Missing Number in an array
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;int i;
        for( i = 0 ; i < nums.length;i++){
            ans = ans ^ nums[i] ^ i;
        }
        return ans ^ i;
    }
}

//xor
// 0 0 -> 0
// 0 1 -> 1
// 1 0 -> 1
// 1 1 -> 0