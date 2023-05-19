package dynamicProgramming;

// bounded knapsack
public class KnapsackRevision {
    public static void main(String[] args) {
//        int[] wt = {3,4,5,2,1,6};
//        int[] val = {30,50,60,40,10,120};
        int[] wt = {3,4,5};
        int[] val = {30,50,60};
        int maxWt = 8;

        int maxValue = getMaxValueRecursion(wt, val, wt.length, maxWt);
        System.out.println(maxValue);

        int[][] dp = new int[wt.length][maxWt+1];
        for(int i=0; i<wt.length; i++){
            for(int j=0; j<=maxWt; j++){
                dp[i][j]  = -1;
            }
        }
        int maxValue1 = getMaxValueMemoization(wt, val, wt.length, maxWt, dp);
        System.out.println(maxValue1);

        int maxValue2 = getMaxValueTabulation(wt, val, maxWt);
        System.out.println(maxValue2);
    }

    private static int getMaxValueTabulation(int[] wt, int[] val, int maxWt){
        int n = wt.length;
        int[][] dp = new int[n][maxWt+1];

        for(int i=wt[0]; i<=maxWt; i++){
            dp[0][i] = val[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=maxWt; j++){
                int ntc = dp[i-1][j];
                int tc = 0;
                if(wt[i]<=j){
                    tc = val[i]+dp[i-1][j-wt[i]];
                }

                dp[i][j] = Math.max(tc, ntc);
            }
        }
        for(int i=0; i<n;i++){
            for (int j=0; j<=maxWt; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n-1][maxWt];
    }
    private static int getMaxValueMemoization(int[] wt, int[] val, int n, int maxWt, int[][] dp){
        if(maxWt<=0) return 0;
        if(n==0){
            if(wt[0] <= maxWt) return val[0];
            return 0;
        }
        if(dp[n-1][maxWt]!=-1) return dp[n][maxWt];
        int ntc = getMaxValueMemoization(wt, val, n-1, maxWt, dp);
        int tc = 0;
        if(wt[n-1]<=maxWt){
            tc = val[n-1]+getMaxValueMemoization(wt, val, n-1, maxWt-wt[n-1], dp);
        }

        return dp[n-1][maxWt] = Math.max(tc, ntc);
    }

    private static int getMaxValueRecursion(int[] wt, int[] val, int n, int maxWt){
        if(maxWt<=0) return 0;
        if(n==0){
            if(wt[0] <= maxWt) return val[0];
            return 0;
        }

        int ntc = getMaxValueRecursion(wt, val, n-1, maxWt);
        int tc = 0;
        if(wt[n-1]<=maxWt){
            tc = val[n-1]+ getMaxValueRecursion(wt, val, n-1, maxWt-wt[n-1]);
        }

        return Math.max(tc, ntc);
    }

}
