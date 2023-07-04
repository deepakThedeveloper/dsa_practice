package recursion;

public class MaximumSumOfNonAdjacentElements {
    public static void main(String[] args) {
        int[] a = {5,2,4,3,6};
        int maxSum = sumSubsequenceBetterApproach(a, a.length-1);
        System.out.println("maximum sum:"+maxSum);
        int maxSum1 = subSequence(a, a.length-1, -1);
        System.out.println("maximum sum:"+maxSum1);

        int maxSum2 = sumSubsequenceBetterApproachWithRotatedArray(a, a.length-1, false);
        System.out.println("maximum sum rotated array:"+maxSum2);
    }

    private static int sumSubsequenceBetterApproach(int[] a, int n){
        if(n==0) return a[n];
        if(n<0) return 0;

        int pick = sumSubsequenceBetterApproach(a, n-2) + a[n];
        int notPick = sumSubsequenceBetterApproach(a, n-1);

        return Math.max(pick, notPick);
    }

    private static int sumSubsequenceBetterApproachWithRotatedArray(int[] a, int n, boolean visited){
        if(n==0){
            return visited ? 0 : a[n];
        }
        if(n<0) return 0;

        int pick = sumSubsequenceBetterApproachWithRotatedArray(a, n - 2, visited || n == a.length-1) + a[n];
        int notPick = sumSubsequenceBetterApproachWithRotatedArray(a, n-1, visited);

        return Math.max(pick, notPick);
    }

    private static int subSequence(int[] a, int n, int prevInd){
        if(n==0){
            return prevInd - n > 1 ? a[n] : 0;
        }
        if(n<0) return 0;

        int pick = Integer.MIN_VALUE;
        if(prevInd-n > 1 || prevInd == -1){
            pick = subSequence(a, n-1, n) + a[n];
        }
        int notPick = subSequence(a, n-1, prevInd);

        return Math.max(pick, notPick);
    }
}
