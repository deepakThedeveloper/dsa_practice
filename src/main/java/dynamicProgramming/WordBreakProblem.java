package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
    public static void main(String[] args) {
        String sen = "microsofthiring";
        Set<String> words = new HashSet<>(Arrays.asList("micro", "soft", "hi", "ring", "hiring", "microsoft"));

        int[] dp = new int[sen.length()];
        Arrays.fill(dp, -1);
        int count1 = countSentencesMemoization(words, sen, 0, dp);
        System.out.println(count1);

        int count2 = countSentencesTabulation(words, sen);
        System.out.println(count2);
    }
    private static int countSentencesMemoization(Set<String> words, String sen, int idx, int[] dp){
        if(sen.length() == idx){
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx];
        String str = "";
        int sum = 0;
        for(int i=idx; i<sen.length(); i++){
            str = str + sen.charAt(i);
            if(words.contains(str)){
                sum+= countSentencesMemoization(words, sen, i+1, dp);
            }
        }
        return dp[idx] = sum;
    }

    private static  int countSentencesTabulation(Set<String> words, String sen){
        int n = sen.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int j = n-1; j>=0; j--){
            String str = "";
            int sum = 0;
            for(int i=j; i<n; i++){
                str = str + sen.charAt(i);
                if(words.contains(str)){
                    sum+= dp[i+1];
                }
            }
            dp[j] = sum;
        }
        return dp[0];
    }
}
