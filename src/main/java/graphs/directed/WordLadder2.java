package graphs.directed;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;


//todo: stopped typing the code because of not felling to continue with this for now. will work on this and optimized approach of striver later
public class WordLadder2 {
    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","dog","log","cog"};
        String start = "hit";
        String end = "cog";

        int min = getAllTransformations(words, start, end);
        System.out.println(min);
    }

    private static int getAllTransformations(String[] wordList, String start, String end){
        Set<Character> uniqueChar = getUniqueChar(wordList);
        System.out.println(uniqueChar);
        Set<String> words = Arrays.stream(wordList).collect(Collectors.toSet());
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(start);
        queue.add(path);

        while(!queue.isEmpty()){
            int size = queue.size();
            String temp = "";
            for(int j=0; j<size; j++) {
                List<String> paths = queue.poll();
                String spath = paths.get(paths.size() - 1);
                for (int i = 0; i < spath.length(); i++) {
                    for (char c : uniqueChar) {
                        temp = spath.substring(0, i) + c + spath.substring(i + 1);
                        if (words.contains(temp)) {
                            paths.add(temp);
                            queue.add(paths);
                        }
                    }
                }
            }
            if(temp.equals(end)){
                break;
            }
            words.remove(temp);
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
