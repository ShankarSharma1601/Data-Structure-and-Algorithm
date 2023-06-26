// Kth Element of Two Sorted Array

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i = 0 , j = 0;
        while(--k > 0){
            if(i < n && j < m){
                if(arr1[i] < arr2[j]) i++;
                else j++;
            }
            else{
                if(i < n) i++;
                else j++;
            }
        }
        
        if(i < n && j < m) return Math.min(arr1[i] , arr2[j]);
        else{
            if(i < n) return arr1[i];
            else return arr2[j];
        }
    }
}

// Alternate Solution
// Time Complexity : O(log(min(m , n)))
// Space Complexity : O(1)

class Solution{
    public static int kthelement(int arr1[], int arr2[], int m, int n, int k) {
        if(m > n) {
            return kthelement(arr2, arr1, n, m, k); 
        }
            
        int low = Math.max(0,k-m), high = Math.min(k,n);
            
        while(low <= high) {
            int cut1 = (low + high) >> 1; 
            int cut2 = k - cut1; 
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1]; 
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1]; 
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2]; 
                
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1; 
            }
        }
        return -1;
    }
}