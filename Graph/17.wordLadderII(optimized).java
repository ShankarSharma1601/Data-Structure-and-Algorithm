// Optimized word ladder II
// here we first find the minimum steps required to transform from beginWord to endWord
// And then backtrack from the endWord to beginWord 
// In this way we optimized our code from the previous version of WordLadderII.java

class Solution {
    Map<String ,  Integer> map = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    String b;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        for(String str : wordList){
            set.add(str);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        b = beginWord;
        map.put(beginWord , 1);
        set.remove(beginWord);
        int size = beginWord.length();
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(word.equals(endWord)) break;

            int steps = map.get(word);
            for(int i = 0;i < size;i++){
                char original = word.charAt(i);
                for(char ch = 'a';ch <= 'z';ch++){
                    char wordArray[] = word.toCharArray();
                    wordArray[i] = ch;
                    String new_word = new String(wordArray);
                    if(set.contains(new_word)){
                        queue.add(new_word);
                        set.remove(new_word);
                        map.put(new_word , steps + 1);
                    }
                }
            }
        }
        if(map.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord , seq);
        }
        return ans;
    }
    private void dfs(String word , List<String> seq){
        if(word.equals(b)){
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return ;
        }
        int steps = map.get(word);
        int size = word.length();
        for(int i = 0;i < size;i++){
            char original = word.charAt(i);
            for(char ch = 'a';ch <= 'z';ch++){
                char wordArray[] = word.toCharArray();
                wordArray[i] = ch;
                String new_word = new String(wordArray);
                if(map.containsKey(new_word) && (steps == map.get(new_word) + 1) ){
                    seq.add(new_word);
                    dfs(new_word , seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
}