// Longest Common Prefix
// Time Complexity : O(n*min(|arr[i]|))
// Space Complexity : O(min(|arr[i]|))

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        return strs[0];
    }
}

// Alternate Solution

class Solution{
    int findMinLength(String arr[], int n){
        int min = arr[0].length();
 
        for (int i = 1; i < n; i++){
            if (arr[i].length() < min){
                min = arr[i].length();
            }
        }
 
        return (min);
    }

    String longestCommonPrefix(String arr[], int n){
        
       int minlen = findMinLength(arr, n);
 
        String result = ""; 
        char current;
 
        for (int i = 0; i < minlen; i++){
            current = arr[0].charAt(i);
 
            for (int j = 1; j < n; j++){
                if (arr[j].charAt(i) != current){
                    if(result=="") return "-1";
                    return result; 
                }
            }
            result += (current);
        }
 
        return (result);   
    }
}