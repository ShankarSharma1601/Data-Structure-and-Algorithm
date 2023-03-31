// Intersection of two Sorted Arrays
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    public static ArrayList<Integer> intersectionOfArrays(int A[] , int B[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0 , j = 0;
        int n = A.length;
        int m = B.length;

        while(i < n && j < m){
            if(A[i] < B[j]) i++;
            else if(A[i] > B[j]) j++;
            else{
                ans.add(A[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
}