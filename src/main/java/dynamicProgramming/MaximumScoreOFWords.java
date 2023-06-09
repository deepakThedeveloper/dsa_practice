package dynamicProgramming;

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

        int[] dp = new int[words.length];
        Arrays.fill(dp, -1);
        int maxScore1 = maxScoreMemoizatio(words.length-1, c1, words, score, dp);
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
        System.out.println(maxScore1);
   }

    private static int maxScoreMemoizatio(int n, int[] c1, String[] words, int[] scores, int[] dp){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int take = 0;
        String str = words[n];
        int score = canIncludeWord(str, c1, scores);
        if(score !=-1) take = score + maxScoreMemoizatio(n-1, c1, words, scores,  dp);
        refillData(str, c1);

        int notTake = maxScoreMemoizatio(n-1, c1, words, scores, dp);

        return dp[n] = Math.max(take, notTake);
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
