package dynamicProgramming.lcs;

public class TargetSumPlusMinus {
    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int target = 3;

        int count = getCount(a, target, 0,a.length-1);
        System.out.println(count);

        int count2 = getCount1(a, target, a.length-1);
        System.out.println(count2);

        int[][] dp = new int[a.length][target+1];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = -1;
            }
        }

        // todo
//        int count1 = getCountMemoization(a, target, a.length-1, dp);
//        System.out.println(count1);
    }

    private static int getCount(int[] a, int target, int sum, int length) {
        if(target == sum) return 1;
        if(length == 0 ){
            if(sum+a[0] == target) return 1;
            if(sum-a[0] == target) return 1;
            return 0;
        }

        int neg = getCount(a, target, -a[length]+sum, length-1);
        int pos = getCount(a, target, a[length]+sum, length-1);

        return neg + pos;
    }

    private static int getCount1(int[] a, int target, int length) {
        if(target == 0){
            return 1;
        }
        if(length == -1 ){
            return 0;
        }

        int pos = getCount1(a, a[length]-target,  length-1);
        int neg = getCount1(a, -a[length]-target,  length-1);

        return neg + pos;
    }
}
