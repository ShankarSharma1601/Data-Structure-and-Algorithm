// Merge Sorted Array Without Extra Space
// Time Complexity : O(n + m)
// Space Complexity : O(1)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int first = m - 1 ; int second = n - 1 ;
        int finals = m + n - 1;
        while( first >= 0 && second >= 0){
            nums1[finals--] = nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
        }
        while(second >= 0){
            nums1[finals--] = nums2[second--];
        }
    }
}

// Alternate Solution
class Solution{
    public void merge(int arr1[] , int arr2[] , int n , int m){
        int i = n - 1;
        int j = 0;
        
        while(i >= 0 && j < m){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}