// Palindrome Partioning
// Time Complexity : O(2^n)
// Space Complexity : O(N) recursion stack


class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> candidates = new ArrayList<>();
        backtrack(s, ans, candidates, 0);
        return ans;
    }
    
    private void backtrack(String s, List<List<String>> ans, List<String> candidates, int start){
        if (start == s.length()) {
            ans.add(new ArrayList<>(candidates));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String candidate = s.substring(start, i + 1);
            if (!isPalindrome(candidate)) continue;
            candidates.add(candidate);
            backtrack(s, ans, candidates, i + 1);
            candidates.remove(candidates.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}