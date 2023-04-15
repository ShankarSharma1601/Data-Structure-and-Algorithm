// Longest Consecutive Sequence
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int longStreak = 0;
        for(int val : set){
            if( !set.contains(val - 1)){
                int currNum = val;
                int currStreak = 1;
                while(set.contains(currNum + 1)){
                    currStreak++;
                    currNum++;
                }
                longStreak = Math.max(longStreak , currStreak);
            }
        }
        return longStreak;
    }
}

// Another Approach
// Brute Force
// Simply Sort the Array and run a for loop
// to find the longest consecutive sequence
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution{
    public int longestConsecutive(int nums[]){
        if(nums.length == 0 || nums == null){
            return 0;
        }

        Arrays.sort(nums);

        int ans = 1;
        int prev = nums[0];
        int curr = 1;

        for(int i = 1;i < nums.length;i++){
            if(nums[i] == prev + 1){
                curr++;
            }
            else if(nums[i] != prev){
                curr = 1;
            }
            prev = nums[i];
            ans = Math.max(ans , curr);
        }
        return ans;
    }
}