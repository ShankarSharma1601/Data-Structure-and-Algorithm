// Letter Combination of a Phone Number
// Time Complexity : O(4^n)
// Space Complexity : O(n)

class Solution {
    
    String code[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> getlc(String str){
        if(str.length() == 0){
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        //235
        char ch = str.charAt(0);//2
        List<String> temp = getlc(str.substring(1));//35
        List<String> ans = new ArrayList<>();
        String codeofch = code[ch-'0'];//abc
        for(int i = 0;i<codeofch.length();i++){
            char ch_codeofch = codeofch.charAt(i);//a
            for(String val : temp){
                ans.add(ch_codeofch + val);//a + 35
            }
        }
        return ans;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            List<String> ans = new ArrayList<>();
            return ans;
        }
        return getlc(digits);
    }
}