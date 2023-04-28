// Reverse Pair
// A reverse pair is a pair (i, j) where:
//   0 <= i < j < nums.length and
//   nums[i] > 2 * nums[j].
// Time Complexity : O(nlogn)
// Space Complexity : O(n)


class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums , 0 , nums.length - 1);
    }
    private int mergeSort(int nums[] , int low , int high){
        if(low >= high) return 0;
        int mid = low + ( high - low) / 2;
        int ans = mergeSort(nums , low , mid);
        ans += mergeSort(nums , mid + 1 , high);
        ans += merge(nums , low , mid , high);
        
        return ans;
    }
    private int merge(int nums[] , int low , int mid , int high){
        int count = 0;
        int j = mid + 1;
        for(int i = low ;i<= mid;i++){
            while(j <= high && nums[i] > (2 * (long)nums[j])){
                j++;
            }
            count += j - (mid + 1);
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low , right = mid + 1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left++]);
            }
            else temp.add(nums[right++]);
        }
        
        while(left <= mid) temp.add(nums[left++]);
        while(right <= high) temp.add(nums[right++]);
        
        for(int i = low;i<= high;i++){
            nums[i] = temp.get(i - low);
        }
        
        return count;
    }
}