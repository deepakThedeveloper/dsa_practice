package recursion;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,4};
        int maxSum = sumSubsequenceStriver(a, a.length-1);
        System.out.println("maximum sum:"+maxSum);
        int maxSum1 = subSequence(a, 0, 0,"");
        System.out.println("maximum sum:"+maxSum1);
    }

    private static int sumSubsequenceStriver(int[] a, int n){
        if(n==0) return a[n];
        if(n<0) return 0;

        int pick = sumSubsequenceStriver(a, n-2) + a[n];
        int notPick = sumSubsequenceStriver(a, n-1) + 0;

        return Math.max(pick, notPick);
    }

    //todo.
    private static int subSequence(int[] a, int ind, int prevInd, String op){
        if(ind == a.length-1){
            System.out.print(op+a[ind]+" ");
            return a[ind];
        }
        if(ind > a.length-1) return 0;

        int pick = Integer.MIN_VALUE;
        if(ind-prevInd !=1){
            pick = subSequence(a, ind+1, ind, op+(ind+1)) + a[ind];
        }
        int notPick = subSequence(a, ind+1, prevInd,op)+0;

        return pick != Integer.MIN_VALUE ? Math.max(pick, notPick) : notPick;
    }
}
