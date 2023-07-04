package dynamicProgramming.subset.combination.group1;

import java.util.Arrays;

public class CoinCombinationFixedCoins {
    public static void main(String[] args) {
        int[] denom = {1,2};
        int n = 8;
        int fixedCoins = 2;
        //findTotalCoinCombinations(denom, n);
        //findTotalUniqueCoinCombinations(denom, n);
//        findTotalCoinCombinationsWithFixedCoins(denom, n, fixedCoins);
        minCoinsNeeded(denom, n);
    }

    // denom = 1,3,5
    private static void minCoinsNeeded(int[] denom, int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            if(i==2) {
                dp[i] = dp[i - 1] + 1;
            }
            if(i>=3){
                dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
            }
            if(i>=5){
                dp[i] = Math.min(dp[i], dp[i-5]) + 1;
            }
        }
        System.out.println("min coins needed:"+dp[n]);
    }


    private static int coinCombinationsSumDP(int k) {
        int[] dp = new int[k];
        int[] j = {2,3,5};
        for(int i=0; i<3; i++){
            for(int l = 0; l<k; l++){
                if(l==j[i] || l==0){
                    dp[l] = 1;
                }
                else if (l>j[i]){
                    if(dp[l-j[i]] != 0){
                        dp[l] +=1;
                    }
                }
            }

        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp[k-1];
    }

    //denom = 1,2,3,5
    //todo
    private static void findTotalUniqueCoinCombinations(int[] denom, int n) {
        int[][] dp = new int[5][n+1]; // 5 denomination{1,2,3,5}
        dp[0][0] = 1;
        for(int row = 0; row<5; row++){
            dp[row][0] = 1;
        }

        for(int i=1; i<=n; i++){
            for(int j=1;j<5; j++){
                if(i>=1){
                    dp[i][j] = dp[i-1][1];
                }
                if(i>=2){
                    dp[i][j] = dp[i][j]+dp[i-2][2];
                }
                if(i>=3){
                    dp[i][j] = dp[i][j]+dp[i-3][3];
                }
                if(i>=5){
                    dp[i][j] = dp[i][j]+dp[i-5][5];
                }


            }
        }
    }

    /*
     I have total fixedCoins lets suppose is 7. means these are count of total coins I have which consists of denom{1,3,5,7}
     logic: f(n,t) -  n = total amount, t = total coins available
     base case = f(0,0) - means zero rupees we need to give and zero coins i have. means 1 way
     base case = f(0,1) - means zero rupees we need to give and 1 coins i have. means 0 ways as I need to exhaust my coins
     test cases = f(1,1) - means 1 rupees we need to give and 1 coins i have. means 1 ways
     test case = f(2,1) - means 2 rupees we need to give and 1 coins i have. means 0 ways because If i give 1 denom note then
     again I need to give 1 for which I have no coins left. I cant use 3 denom as I need to pay 2 rupees

     f(n,t) = f(n-1,t-1)+f(n-3,t-1)+f(n-5,t-1)+f(n-7,t-1).  for every deduction in total amount, I can give either 1, 3, 5 or 7 denom
     note which will make amount I need to pay is (n-denom[j]). bit for every single payment my one coin will be reduced so t-1.
     */
    private static void findTotalCoinCombinationsWithFixedCoins(int[] denom, int n, int fixedCoins) {
        int[][] dp = new int[n+1][fixedCoins+1];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int row=1; row<=n; row++){
            dp[row][0] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=fixedCoins; j++){
                if(i>=1){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(i>=3){
                    dp[i][j] = dp[i][j] + dp[i-3][j-1];
                }
                if(i>=5){
                    dp[i][j] = dp[i][j] + dp[i-5][j-1];
                }
                if(i>=7){
                    dp[i][j] = dp[i][j] + dp[i-7][j-1];
                }
            }
        }
        System.out.println("coin combinations:"+dp[n][fixedCoins]);
    }

    private static void findTotalCoinCombinations(int[] denom, int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<denom.length; j++){
                if(denom[j] > i) break;
                dp[i] = dp[i]+dp[i-denom[j]];
            }
        }

        System.out.println("coin combinations:"+dp[n]);
    }
}
