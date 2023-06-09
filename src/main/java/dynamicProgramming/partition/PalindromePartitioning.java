package dynamicProgramming.partition;

import java.util.Arrays;

public class PalindromePartitioning {
    public static void main(String[] args) {
        char[] c = {'b','a','b','a','b','c','b','a','d','c','e','d','e'};
        int[] dp = new int[c.length];
        Arrays.fill(dp, -1);
        int minPartition = minPartitionMemoizationRevision(c, 0, c.length, dp);
        System.out.println(minPartition-1);
        int minPartition1 = minPartitionTabulationRevision(c);
        System.out.println(minPartition1);
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

    //todo: summit malick dsa 2
    private static int palindromePartitionWithMinCutsApproach1(){
        return 0;
    }
    //todo: summit malick dsa 2
    private static int palindromePartitionWithMinCutsApproach2(){
        return 0;
    }
}
