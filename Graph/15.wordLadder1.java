// word ladder I
// Complexity : N * word_length * 26 * log(N)


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(beginWord , 1));

        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        while(!queue.isEmpty()){
            pair p = queue.poll();
            String word = p.str;
            int steps = p.dist;

            if(word.equals(endWord)) return steps;

            for(int i = 0;i < word.length();i++){
                char original = word.charAt(i);
                for(char ch = 'a';ch <= 'z';ch++){
                    char wordArray[] = word.toCharArray();
                    wordArray[i] = ch;
                    String new_word = new String(wordArray);

                    if(set.contains(new_word)){
                        set.remove(new_word);
                        queue.add(new pair(new_word , steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class pair{
    String str;
    int dist;
    pair(String s , int d){
        str = s;
        dist = d;
    }
}