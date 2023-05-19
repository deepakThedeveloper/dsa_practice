package dynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] weight = {2,5,1,3,4}; // 2-5, 2-1-4, 3-4,
        int[] value = {15,14,10,45,30};

        int k = 7;

//        printMaxValue(weight, value, k, -1, 0, 0, "");
//        System.out.println("max value:"+max + " wt:"+combination);

//        Data finalVal =  printMaxValueSecondApproach(weight, value, k, -1, 0, 0, "");
//        System.out.println("max value:"+finalVal.sum+" wt:"+finalVal.val);

        int finalVal =  printMaxValueTabulation(weight, value, k);
        System.out.println("max value:"+finalVal);
    }

    private static int printMaxValueTabulation(int[] wt, int[] val, int k) {
        int[][] dp = new int[wt.length+1][k+1];
        for(int i=0; i<=k; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<=wt.length; i++){
            dp[i][0] = 0;
        }

        int k1 = 0;
        for(int row=1; row<=wt.length; row++){
            for(int col = 1; col<=k; col++){
                if(col<wt[k1]){
                    dp[row][col] = dp[row-1][col];
                }
                else{

                    int max = dp[row-1][col];
                    int mul = 1;
                    for(int k2 = wt[k1]; k2<=col; ){
                        int diff = col-k2;
                        int v1 = dp[row-1][diff];
                        int finalVal = v1+(val[k1]*mul);
                        if(finalVal>max){
                            max = finalVal;
                        }
                        mul++;
                        k2=k2*mul;
                    }
                    dp[row][col] = max;
                }
            }
            k1++;
        }
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return dp[wt.length][k];
    }

    static int max = Integer.MIN_VALUE;
    static String combination = "";
    private static void printMaxValue(int[] wt, int[] val, int k, int n, int sum, int totalWt, String op) {
        if(totalWt>k){
            return;
        }

        if(n == wt.length-1 || totalWt == k){
            if(sum>max){
                max = sum;
                combination = op;
            }
            return;
        }

        for(int i=0; i<wt.length; i++) {
            printMaxValue(wt, val, k, i, sum + val[i], totalWt + wt[i], op + wt[i]);
        }
    }
//
//    private static Data printMaxValueSecondApproach(int[] wt, int[] val, int k, int n, int sum, int totalWt, String op) {
//        if(totalWt>k){
//            return new Data(0, "");
//        }
//        if(totalWt == k || n == wt.length-1){
//            return new Data(sum, op);
//        }
//        Data tempData = new Data(0,"");
//        for (int i=0; i<wt.length; i++) {
//            Data lData = printMaxValueSecondApproach(wt, val, k, i, sum + val[i], totalWt + wt[i], op + wt[i]);
//            if(lData.sum>tempData.sum){
//                tempData = lData;
//            }
//        }
//        return tempData;
//    }
}

