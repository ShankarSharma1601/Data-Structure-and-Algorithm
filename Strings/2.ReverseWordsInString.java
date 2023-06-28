// Reverse Words in a String
// Time Complexity : O(n)
// Space Complexity : O(1)


class Solution{
    public String reverseWords(String s){
        String temp = "";
        String ans = "";

        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                temp += ch;
            }
            else if(ch == ' '){
                if(!ans.equals("")){
                    ans = temp + " " + ans;
                }
                else ans = temp;

                temp = "";
            }
        }

        if(!temp.equals("")){
            if(!ans.equals("")){
                ans = temp + " " + ans;
            }
            else ans = temp;
        }

        return ans;
    }
}

// Alternate Solution
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}