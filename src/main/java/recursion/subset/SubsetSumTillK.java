package recursion.subset;

import matrix.Util;

public class SubsetSumTillK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int k = 5;

        int count1 = getCountOfSubsetSumMemoization(a.length - 1, k, a);
        System.out.println("recursion:" + count1);
    }

    private static int getCountOfSubsetSumMemoization(int n, int k, int[] a) {
        if(k==0) return 1;
        if(n==0) return a[0] == k ? 1 : 0;

        int ntc = getCountOfSubsetSumMemoization(n-1, k, a);
        int tc = 0;
        if(a[n]<=k)
            tc = getCountOfSubsetSumMemoization(n-1, k-a[n], a);

        return ntc + tc;
    }
}
