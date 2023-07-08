// Implement Atio
// Time Complexity : O(n)
// Space Complexity : (1)


class Solution{
    int atoi(String str) {
        int ans = 0;
        try{
            ans = Integer.parseInt(str);
        }
        catch(Exception e){
            ans = -1;
        }
        return ans;
    }
}