class Pair{
    String word;
    int steps;
    Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(beginWord, 1));
        
        HashSet<String> set = new HashSet<>();
        int len = wordList.size();
        
        for(int i = 0; i < len;i++){
            set.add(wordList.get(i));
        }
        
        set.remove(beginWord);
        
        while(!que.isEmpty()){
            String word = que.peek().word;
            int steps = que.peek().steps;
            
            que.poll();
            if(word.equals(endWord)) return steps;
            
            for(int i = 0; i < word.length(); i++){
                char original = word.charAt(i);
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        que.add(new Pair(newWord, steps+1));
                    }
                }
                word = word.substring(0, i) + original + word.substring(i + 1);
            }
        }
        return 0;
    }
}