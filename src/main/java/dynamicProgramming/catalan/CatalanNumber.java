package dynamicProgramming.catalan;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class CatalanNumber {
    public static void main(String[] args) {
        int n = 3;
        int[] dp = catalanNumber(n);

        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
        System.out.println(dp[n]);
   }

    public static int[] catalanNumber(int n){
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        // j<k : (c[j] * c[k]) * 2. when j==k c[j] + c[k];
        for(int i=2; i<=n; i++){
            int sum=0;
            for(int j=0, k=i-1; j<=k; j++, k--){
                // in case of odd numbers it happens when j==k. at this time, c[j] + c[k]
                if(j==k){
                    sum += dp[j]*dp[k];
                }
                // till j<k (c[j] * c[k]) * 2
                else{
                    sum += 2*(dp[j]*dp[k]);
                }
            }
            dp[i] = sum;
        }
        return dp;
    }
}
