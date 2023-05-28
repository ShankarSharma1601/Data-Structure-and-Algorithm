// Fint out how many times has an array been rotated
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution{
    int findKRotation(int arr[] , int n){
        if(arr[0] <= arr[n-1]) return 0;
        int left = 0 , right = n - 1;
        while(left < right){
            int mid = left + ( right - left ) / 2;
            if( mid - 1 >= 0 && arr[mid] < arr[mid - 1]) return mid; 
            if(arr[mid + 1] < arr[mid]) return mid + 1;
            
            if(arr[mid] >= arr[left]) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

// Alternate Solution
// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution{
    int findKRotation(int arr[] , int n){
        int prev = arr[0];
        Arrays.sort(arr);
        int index = -1;

        for(int i = 0;i < n;i++){
            if(arr[i] == prev){
                index = i;
                break;
            }
        }

        if(index == 0) return 0;
        return n - index;
    }
}