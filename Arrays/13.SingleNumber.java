// Find the number appearing once in twice array
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution{
    public int singleNUmber(int nums[]){
        int xor = 0;
        for(int val : nums){
            xor ^= val;
        }
        return xor;
    }
}