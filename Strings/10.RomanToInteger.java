// Roman To Integer
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return -1;
        
        HashMap<Character , Integer> map = new HashMap<Character , Integer>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X' , 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M',1000);
        
        int len = s.length();
        int ans = map.get(s.charAt(len - 1));
        for(int i = len - 2;i >= 0;i--){
            char ch = s.charAt(i);
            if(map.get(ch) >= map.get(s.charAt(i+1))){
                ans += map.get(ch);
            }
            else{
                ans -= map.get(ch);
            }
        }
        return ans;
    }
}