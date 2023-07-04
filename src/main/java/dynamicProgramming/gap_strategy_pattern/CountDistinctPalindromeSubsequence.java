package dynamicProgramming.gap_strategy_pattern;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctPalindromeSubsequence {
    public static void main(String[] args) {
        String str = "abacdaea";
        int count = countDistinctPalindromicSubsequence(str);
        System.out.println(count);
    }

    //todo: not working summit mallik dsa 2
    private static int countDistinctPalindromicSubsequence(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        Map<Character, Integer> map = new HashMap<>();
        int[] prev = new int[n];
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            prev[i] = map.getOrDefault(c, -1);
            map.put(c, i);
        }

        map.clear();;
        int[] next = new int[n];
        for(int i=n-1; i>=0; i--){
            char c = str.charAt(i);
            next[i] = map.getOrDefault(c, -1);
            map.put(c, i);
        }
        System.out.println("next:");
        Arrays.stream(next).forEach(v->System.out.print(v+" "));
        System.out.println();

        System.out.println("prev:");
        Arrays.stream(prev).forEach(v->System.out.print(v+" "));
        System.out.println();

        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0)dp[i][j] = 1;
                else if(g==1)dp[i][j] = 2;
                else {
                    char start = str.charAt(i);
                    char end = str.charAt(j);
                    int v;
                    if (start != end) {
                        v = dp[i][j - 1] + dp[i + 1][j] - dp[i+1][j-1];
                    } else {
                        int next1 = next[i];
                        int prev1 = prev[j];
                        if(next1 > prev1){
                            v = 2*dp[i+1][j-1]+2;
                        }
                        else if(next1 == prev1){
                            v = 2*dp[i+1][j-1]+1;
                        }
                        else{
                            v = 2*dp[i+1][j-1] - dp[next1+1][prev1-1];
                        }
                    }
                    dp[i][j] = v;
                }
            }
        }
        Util.printMatrix(dp);
        return dp[0][n-1];
    }

    @AllArgsConstructor
    static class Pair{
        int secondIndex;
        int secondLastIndex;
    }
}

