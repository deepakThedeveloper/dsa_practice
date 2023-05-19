package dynamicProgramming;

import java.util.Arrays;

/*
there has to be 2 partition s1, s2 such that s1>=s2 and s1-s2 = 3;
 */
public class CountSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int diff = 10;

        int sum = Arrays.stream(a).sum();
        /*
            s1+s2+diff = sum;
            s2+s2+diff = sum
            2s2 = sum-diff;
            s2 = sum-diff/2;

            target = s2;
         */
       int target = (sum-diff)/2;
       if(target>0 && target%2==0) {
           int count = getCountOfSubsetTabulation(a, a.length, target);
           System.out.println(count);
       }
    }
    private static int getCountOfSubsetTabulation(int[]a, int n, int k){
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        if(a[0] <=k) dp[0][a[0]] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                int ntc = dp[i-1][j];
                int tc = 0;
                if(a[i]<=j)
                    tc = dp[i-1][j-a[i]];

                dp[i][j] = ntc + tc;
            }
        }
        return dp[n-1][k];
    }
}
