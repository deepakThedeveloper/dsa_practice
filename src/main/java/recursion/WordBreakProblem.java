package recursion;

import matrix.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
    public static void main(String[] args) {
        String sen = "microsofthiring";
        Set<String> words = new HashSet<>(Arrays.asList("micro", "soft", "hi", "ring", "hiring", "microsoft"));
        printSentences(words, sen, "");
        int count = countSentences(words, sen, 0);
        System.out.println(count);
    }
    private static void printSentences(Set<String> words, String sen, String op){
        if(sen.length() == 0){
            System.out.println(op);
            return;
        }
        String str = "";
        for(int i=0; i<sen.length(); i++){
            str = str + sen.charAt(i);
            if(words.contains(str)){
                String newStr = sen.substring(i+1);
                printSentences(words, newStr, op+"-"+str);
            }
        }
    }

    private static int countSentences(Set<String> words, String sen, int idx){
        if(sen.length() == idx){
            return 1;
        }
        String str = "";
        int sum = 0;
        for(int i=idx; i<sen.length(); i++){
            str = str + sen.charAt(i);
            if(words.contains(str)){
                sum+= countSentences(words, sen, i+1);
            }
        }
        return sum;
    }

}
