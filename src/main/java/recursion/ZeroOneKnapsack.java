package recursion;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {4,4,5};
        int[] val = {50, 60, 100};
        int sackWt = 8;

        int maxValue = maxValueRevision(wt, val, sackWt, wt.length-1);
        System.out.println("maxValue:"+maxValue);
    }
    private static int maxValueRevision(int[] wt, int[] value, int sackWt, int n){
        if(n==0){
            if(wt[n]<=sackWt) return value[n];
            return 0;
        }
        if(sackWt <= 0) return 0;

        int pick = wt[n]<=sackWt ? maxValueRevision(wt, value, sackWt-wt[n], n-1) + value[n]:0;
        int notPick = maxValueRevision(wt, value, sackWt, n - 1);

        return Math.max(pick, notPick);
    }


    static int max = Integer.MIN_VALUE;
    static String combination = "";

    private static void printMaxValueOld(int[] wt, int[] val, int k, int n, int sum, int totalWt, String op) {
        if (totalWt > k) {
            return;
        }
        if (totalWt == k || n == wt.length - 1) {
            if (sum > max) {
                max = sum;
                combination = op;
            }
            return;
        }
        printMaxValueOld(wt, val, k, n + 1, sum + val[n + 1], totalWt + wt[n + 1], op + wt[n + 1]);
        printMaxValueOld(wt, val, k, n + 1, sum, totalWt, op);
    }
}
