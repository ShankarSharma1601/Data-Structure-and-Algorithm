// Sort Characters By Frequency
// Time Complexity : O(nlogn)
// Space Complexity : O(n)

class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a , b) -> b.freq - a.freq);
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        
        for(Map.Entry<Character , Integer> mpp : map.entrySet()){
            pq.add(new pair(mpp.getKey() , mpp.getValue()));
        }
        
        String ans = "";
        while(!pq.isEmpty()){
            pair p = pq.poll();
            int freq = p.freq;
            char ch = p.ch;
            while(freq-- > 0){
                ans += ch;
            }
        }
        
        return ans;
    }
}

class pair{
    char ch;
    int freq;
    pair(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }
}