package dynamicProgramming.gap_strategy_pattern;

import matrix.Util;

import java.util.Arrays;

public class MinimumPalindromePartitioning {
    public static void main(String[] args) {
        char[] c = {'a','b','c','c','b','c'};
        int[] dp = new int[c.length];
        Arrays.fill(dp, -1);
        int minPartition = minPartitionMemoizationRevision(c, 0, c.length, dp);
        System.out.println(minPartition-1);
        int minPartition1 = minPartitionTabulationRevision(c);
        System.out.println(minPartition1);

        int minPartition2 =  minPartitionTabulationDirect(c);
        System.out.println(minPartition2);
    }

    //tc: n^2
    private static int minPartitionTabulationRevision(char[] a){
        int n = a.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);

        for(int j=n-1; j>=0; j--){
            int min = Integer.MAX_VALUE;
            for(int i=j; i<n; i++){
                if(isPalindrome(a, j, i)){
                    int cost =  1 + dp[i+1];
                    min = Math.min(min, cost);
                }
            }
            dp[j] = min;
        }
        return dp[0]-1;
    }

    //tc: n^3
    private static int minPartitionTabulationDirect(char[] a){
        int len = a.length;
        int[][] dp = new int[len][len];

        for(int g=0; g<len; g++){
            for(int i=0, j=g; j<len; i++, j++){
                if(g==0)dp[i][j] = 0;
                else if(g==1) dp[i][j] = a[i] == a[j] ? 0 : 1;
                else {
                    if(a[i] == a[j]){
                        dp[i][j] = dp[i+1][j-1] == 0 ? 0 : dp[i+1][j-1] + 1;
                    }
                    else{
                        int mainMin = Integer.MAX_VALUE;
                        for(int k = i; k<j; k++){
                            int val = dp[i][k] + dp[k+1][j];
                            mainMin = Math.min(mainMin, val);
                        }
                        dp[i][j] = mainMin + 1;
                    }
                }
            }
        }

        Util.printMatrix(dp);
        return dp[0][len-1];
    }

    private static int minPartitionMemoizationRevision(char[] a, int idx, int n, int[] dp){
        if(idx==n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int i=idx; i<n; i++){
            if(isPalindrome(a, idx, i)){
                min = Math.min(min, 1+ minPartitionMemoizationRevision(a, i+1, n, dp));
            }
        }
        return dp[idx] = min;
    }


    private static boolean isPalindrome(char[] a, int start, int end){
        int i = start, j=end;
        while (start<end){
            if(a[start]!=a[end]) return false;
            start++;
            end--;
        }
        if(i == 0){
        }
        return true;
    }
}
