// Remove Duplicate from Sorted Array
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    int remove_duplicate(int A[], int N){
        int left = 0;
        for(int next = 1; next < N; next++){
            if(A[left] != A[next]){
                left++;
                int temp=A[left];
                A[left]=A[next];
                A[next]=temp;
            }
        }
        return left + 1;
    }
}