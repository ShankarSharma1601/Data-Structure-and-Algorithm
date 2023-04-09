// Majority Element(> n/2 times)
// Time Complexity : O(n)
// Space omplexity : O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int count = 1 , index = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[index] ) count++;
            else count--;
            
            if(count == 0){
                count = 1;
                index = i;
            }
        }
        
        count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == nums[index] ){
                count++;
            }
        }
        if(count > nums.length / 2) return nums[index];
        else return -1;
    }
}