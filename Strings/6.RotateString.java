// Rotate String
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}