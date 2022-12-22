// word ladder II

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
         Set<String> set = new HashSet<>();
         for(String str : wordList){
             set.add(str);
         }

         Queue<List<String>> queue = new LinkedList<>();
         List<String> begin = new ArrayList<>();
         begin.add(beginWord);
         queue.add(new ArrayList<>(begin));

         List<String> usedOnLevel = new ArrayList<>();
         usedOnLevel.add(beginWord);

         int level = 0;
         List<List<String>> ans = new ArrayList<>();

         while(!queue.isEmpty()){
             List<String> vec = queue.poll();

             //erase all word that has been used in the previous levels to transform
             if(vec.size() > level){
                 level++;
                 for(String str : usedOnLevel){
                     set.remove(str);
                 }
             }

             String word = vec.get(vec.size() - 1);

             if(word.equals(endWord)){
                 // the first sequence where we reach the end
                 if(ans.size() == 0){
                     ans.add(new ArrayList<>(vec));
                 }
                 else if(ans.get(0).size() == vec.size()){
                     ans.add(new ArrayList<>(vec));
                 }
             }

             for(int i = 0;i < word.length();i++){
                 char original = word.charAt(i);
                 for(char ch = 'a';ch <= 'z';ch++){
                     char wordArray[] = word.toCharArray();
                     wordArray[i] = ch;
                     String new_word = new String(wordArray);
                     if(set.contains(new_word)){
                         vec.add(new_word);
                         List<String> temp = new ArrayList<>(vec);
                         queue.add(temp);
                         usedOnLevel.add(new_word);
                         vec.remove(vec.size() - 1);
                     }
                 }
             }
         }
        return ans;
    }
}