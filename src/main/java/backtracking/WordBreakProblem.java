package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakProblem {
    public static void main(String[] args) {
        String sen = "microsofthiring";
        String[] words = {"micro", "soft", "hi", "ring", "hiring", "microsoft"};

        Set<String> wordSet = Arrays.stream(words).collect(Collectors.toSet());

        printPossibleSentences(sen, wordSet, "");
    }

    private static void printPossibleSentences(String sen, Set<String> words, String op){
        if(sen.length()==0){
            System.out.println(op);
            return;
        }
        String subString="";
        for(int i=0; i<sen.length(); i++){
            subString += sen.charAt(i);
            if(words.contains(subString)){
                printPossibleSentences(sen.substring(i+1), words, op+" "+subString);
            }
        }
    }
}
