package dynamicProgramming.subset.combination.group1;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = {2,5,1,3,4}; // 2-5, 2-1-4, 3-4,
        int[] value = {15,14,10,45,30};
        int k = 7;
        int finalVal =  maxValue(weight, value, k);
        System.out.println("max value:"+finalVal);
    }

    private static int maxValue(int[] wt, int[] val, int k){
        int len = wt.length;
        int[] dp = new int[k+1];

        for(int i=0; i<len; i++){
            for(int j=1; j<=k; j++){
                if(wt[i] > j) continue;
                int notTake = dp[j];
                int take = dp[j - wt[i]] + val[i];
                dp[j] = Math.max(notTake, take);
            }
        }

        return dp[k];
    }
}

