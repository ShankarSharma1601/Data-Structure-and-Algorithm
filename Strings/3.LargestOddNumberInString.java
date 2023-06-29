// Largest Odd Number in String
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {

    String maxOdd(String s) {
        String ans = "";
        String temp = "";
        int n = 0;
        for(int i = 0;i < s.length();i++){
            temp += s.charAt(i);
            n = s.charAt(i) - '0';
            if(n % 2 == 1) ans = temp;
        }
        return ans;
    }
}

// Alternate Solution
class Solution {
    public String largestOddNumber(String num) {
        for(int i = num.length() -1; i>=0 ;i--){
            if(num.charAt(i) % 2 != 0) return num.substring(0 , i+1);
        }
        return "";
    }
}