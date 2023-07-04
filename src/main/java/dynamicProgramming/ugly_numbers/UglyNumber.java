package dynamicProgramming.ugly_numbers;

import java.util.Arrays;

// asked in google
public class UglyNumber {
    public static void main(String[] args){
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int nthUgly = nthSuperUglyNumber(n, primes);
        System.out.println(nthUgly);
    }

    //leetcode: https://leetcode.com/problems/super-ugly-number/
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n+1];
        int[] pointers = new int[len];

        Arrays.fill(pointers, 1);
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<len; j++){
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;
            for(int j=0; j<len; j++){
                if(primes[j] * dp[pointers[j]] == min){
                    pointers[j] += 1;
                }
            }
        }

        return dp[n];
    }
}
