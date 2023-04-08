// Dutch National flag algorithm
// Sort an Array of 0's 1's and 2's only
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution {
    public void sort012(int[] nums) {
        int low = 0 , mid = 0 , high = nums.length-1;
        while(mid <= high){
            switch(nums[mid]){
                case 0 : {
                   swap(nums , low , mid);
                   low++;
                   mid++;
                   break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    swap(nums , mid , high);
                    high--;
                    break;
                }
            }
        }
    }
    private void swap(int nums[] , int ele1 , int ele2){
        int temp = nums[ele1];
        nums[ele1] = nums[ele2];
        nums[ele2] = temp;
    }
}


// Approach 2
// Keep counting of values and then overwriting the array based on the count 
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    public void sort012(ArrayList<Integer> arr , int n){
        int count0 = 0 , count1 = 0 , count2 = 0;
        for(int val : arr){
            if(val == 0) count0++;
            else if(val == 1) count1++;
            else count2++;
        }

        for(int i = 0;i < count0;i++){
            arr.set(i , 0);
        }
        for(int i = count0;i < count0 + count1;i++){
            arr.set(i , 1);
        }
        for(int i = count0 + count1;i < n;i++){
            arr.set(i , 2);
        }
    }
}


// Approach 3
// Simply sort the array
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution{
    public void sort012(int nums[]){
        Arrays.sort(nums);
    }
}