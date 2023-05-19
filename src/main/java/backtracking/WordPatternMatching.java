package backtracking;

import java.util.*;

public class WordPatternMatching {
    public static void main(String[] args) {
        String word = "mzaddytzaddy";
        String matchee = "abcb";
//        String word = "graphtreegraph";
//        String matchee = "pep";

        Map<Character, String> map = new HashMap<>();
        printMatchedPattern(word, matchee, map);
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
