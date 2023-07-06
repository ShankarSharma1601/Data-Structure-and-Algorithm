// Maximum Nesting Depth of the Parentheses
// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public int maxDepth(String s) {
        int depth = 0 , max = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(') depth++;
            else if(ch == ')') depth--;
            max = Math.max(max , depth);
        }
        return max;
    }
}