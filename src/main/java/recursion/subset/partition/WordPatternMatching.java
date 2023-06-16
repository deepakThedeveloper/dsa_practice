package recursion.subset.partition;

import java.util.*;

public class WordPatternMatching {
    public static void main(String[] args) {
        String word = "mzaddytzaddy";
        String matchee = "abcb";
//        String word = "graphtreegraph";
//        String matchee = "pep";

        Map<Character, String> charWordMap = new HashMap<>();
//        printMatchedPattern(word, matchee, map);
        wordPatternMatch(word, matchee, charWordMap, 0, 0);
    }

    private static void wordPatternMatch(String word, String matchee, Map<Character,
            String> charWordMap, int idx, int j){
        if(j == word.length() && idx == matchee.length()){
            System.out.println(charWordMap);
            return;
        }
        if(j == word.length() || idx == matchee.length()) return;

        for(int i = j; i < word.length(); i++){
            String prefix = word.substring(j, i+1);
            char ch = matchee.charAt(idx);
            if(!charWordMap.containsKey(ch)){
                charWordMap.put(ch, prefix);
                wordPatternMatch(word, matchee, charWordMap, idx+1, i+1);
                charWordMap.remove(ch);
            }
            else{
                String value = charWordMap.get(ch);

                if(prefix.length() < value.length()) continue;
                if(prefix.length() > value.length() || !prefix.equals(value))
                    return;
                wordPatternMatch(word, matchee, charWordMap, idx+1, i+1);
            }
        }
    }

    private static void printMatchedPattern(String word, String matchee, Map<Character, String> map) {
        if(matchee.length() == 0){
            if(word.length() == 0){
                for(Map.Entry<Character, String> mp : map.entrySet()){
                    System.out.print(mp.getKey() +"-->"+mp.getValue()+"  ");
                }
                System.out.println();
            }
            return;
        }

        char c = matchee.charAt(0);
        String rop = matchee.substring(1);
        if(map.containsKey(c)){
            String previousMapping = map.get(c);

            if(word.length()>=previousMapping.length()) {
                String left = word.substring(0, previousMapping.length());
                String right = word.substring(previousMapping.length());
                if (previousMapping.equals(left))
                    printMatchedPattern(right, rop, map);
            }
        }
        else {
            for(int i=0; i<word.length(); i++){
                String left = word.substring(0, i+1);
                String right = word.substring(i+1);
                map.put(c, left);
                printMatchedPattern(right, rop, map);
                map.remove(c);
            }
        }
    }
}
