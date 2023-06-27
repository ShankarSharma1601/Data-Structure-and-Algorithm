// Remove Outermost Paranthesis
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(open > 0) sb.append(ch);
                open++;
            }
            else{
                if(open > 1) sb.append(ch);
                open--;
            }
        }
        return sb.toString();
    }
}