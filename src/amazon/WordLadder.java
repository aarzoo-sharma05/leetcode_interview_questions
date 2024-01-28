package amazon;
import java.util.*;

//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.


class Pair{
    String word;
    int steps;
    public Pair(String w, int s){
        word = w;
        steps = s;
    }
}
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair pair = q.poll();
            String word = pair.word;
            int steps = pair.steps;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedString = new String(replacedCharArray);
                    if(set.contains(replacedString)){
                        q.add(new Pair(replacedString, steps+1));
                        set.remove(replacedString);
                    }
                }
            }
        }
        return 0;
    }
}
