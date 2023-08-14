// Word Break
// Time Complexity : O(nlogn)
// Space Complexity : O(n)


class Solution {
    public boolean wordBreak(String A, List<String> B) {
        
        //recusive solution present in time limit exceed solution
        
       
     
     int n = A.length();
     boolean dp[] = new boolean[n];
     for(int i = 0 ; i < n ; i++){
         for(int j = 0 ; j <= i; j++){
             String tofind = A.substring(j , i+1);
             if(B.contains(tofind)){
                 if(j > 0){
                     dp[i] = dp[i] ||  dp[j-1];
                 }
                 else dp[i] =true;
             }
         }
     }
     // return dp[n-1] > 0 ? true : false;
     
        return dp[n-1];
    }
}