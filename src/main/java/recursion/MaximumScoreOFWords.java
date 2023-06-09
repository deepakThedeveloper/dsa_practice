package recursion;

import java.util.Arrays;

public class MaximumScoreOFWords {
    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] c = {'a','b','c','d','d','d','g','o','o'};
        int[] c1 = new int[26];
        for(int i=0; i<c.length; i++){
            int pos = c[i]-'a';
            c1[pos] ++;
        }
        int[] score = {1, 0, 9, 5, 0, 0, 3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int maxScore = maxScore(words.length-1, c1, words, score,"");
        System.out.println(maxScore);
    }

    private static int maxScore(int n, int[] c1, String[] words, int[] scores, String op){
        if(n<0) {
            return 0;
        }
        int notTake = maxScore(n-1, c1, words, scores, op);
        int take = 0;
        String str = words[n];
        int score = canIncludeWord(str, c1, scores);
        if(score !=-1) take = score + maxScore(n-1, c1, words, scores, op+" "+str);
        refillData(str, c1);
        return Math.max(take, notTake);
    }

    private static void refillData(String str, int[] c1) {
        for(int i=0; i<str.length(); i++) {
            int pos = str.charAt(i)-'a';
            c1[pos]++;
        }
    }

    private static int canIncludeWord(String str, int[] c, int[] scores){
        int score = 0;
        boolean flag = true;
        for(int i=0; i<str.length(); i++){
            int pos = str.charAt(i)-'a';
            if(c[pos]==0){
                flag = false;
            }
            c[pos]--;
            score += scores[pos];
        }
        return !flag ? -1 : score;
    }
}
