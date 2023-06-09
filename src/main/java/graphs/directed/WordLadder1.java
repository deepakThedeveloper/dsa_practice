package graphs.directed;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordLadder1 {
    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","dog","log","cog"};
        String start = "hit";
        String end = "cog";

        int min = minTransformationsNeeded(words, start, end);
        System.out.println(min);
    }

    private static int minTransformationsNeeded(String[] wordList, String start, String end){
        Set<Character> uniqueChar = getUniqueChar(wordList);
        System.out.println(uniqueChar);
        Set<String> words = Arrays.stream(wordList).collect(Collectors.toSet());
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(start, 1));

        while(!queue.isEmpty()){
            Pair<String, Integer> pair = queue.poll();
            String chars = pair.getKey();
            int step = pair.getValue();
            for(int i=0; i<chars.length(); i++){
                for(char c : uniqueChar){
                    String temp = chars.substring(0,i)+c+chars.substring(i+1);

                    if(words.contains(temp)){
                        words.remove(temp);
                        if(temp.equals(end)) return step;
                        queue.add(new Pair<>(temp, step+1));
                    }
                }
            }
        }
        return 0;
    }

    private static Set<Character> getUniqueChar(String[] wordList){
        Set<Character> characters = new HashSet<>();
        for(String word : wordList){
            for(char c : word.toCharArray()){
                characters.add(c);
            }
        }
        return characters;
    }
}
