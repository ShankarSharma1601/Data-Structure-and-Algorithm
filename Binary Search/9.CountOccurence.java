// Count Occurence of number in sorted Array with Duplicates
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution {
    int count(int[] arr, int n, int x) {
        int start = 0 , end = n-1;
        int first = -1;
        while(start <= end){
            int mid = start + ( end - start) / 2;
            if(arr[mid] == x){
                first = mid;
                end = mid - 1;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }
            else start = mid + 1;
        }
        
        //last occurence
        start = 0 ; end = n-1;
        int last = -1;
        while(start <= end){
            int mid = start + ( end - start) / 2;
            if(arr[mid] == x){
                last = mid;
                start = mid + 1 ;
            }
            else if(arr[mid] > x){
                end = mid - 1;
            }
            else start = mid + 1;
        }
        
        if(first == -1 && last == -1) return 0;
        return last - first + 1;
    }
}


// Alternate solution

class Solution {
    int count(int[] arr, int n, int x) {
        return count(arr , n , x);
    }
    private int count(int arr[] , int n , int x){
        int idx = binary(arr , n , x);

        if(idx == -1){
            return 0;
        }

        int k = 1;
        int left = idx - 1;

        while(left >= 0 && arr[left] == x){
            k++;
            left--;
        }

        int right = idx + 1;
        while(right < n && arr[right] == x){
            k++;
            right++;
        }

        return k;
    }
    private int binary(int arr[] , int n , int x){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] < x){
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return -1;
    }
}