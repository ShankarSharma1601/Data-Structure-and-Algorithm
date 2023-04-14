// Leaders in an Array problem
// An element of array is leader if it is greater than 
// or equal to all the elements to its right side. 
// Time Complexity : O(N)
// Space Conplexity : O(1)



class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[n-1]);
        int max = arr[n-1];
        for(int i = n-2;i >= 0;i--){
            if(max <= arr[i]){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}