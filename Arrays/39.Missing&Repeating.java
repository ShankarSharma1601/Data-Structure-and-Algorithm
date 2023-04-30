// Missing and Repeating element in an array
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solve {
    int[] findTwoElement(int arr[], int n) {
        int freq[] = new int[n+1];
        int ans[] = new int[2];
        for(int i = 0;i < n;i++){
            freq[arr[i]]++;
        }
        for(int i = 0;i <= n;i++){
            if(freq[i] > 1){
                ans[0] = i;
            }
            if(freq[i] == 0){
                ans[1] = i;
            }
        }
        return ans;
    }
}