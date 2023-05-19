package recursion;

import matrix.Util;

import static com.sun.tools.attach.VirtualMachine.list;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int lis = lis(0, -1, a);
        System.out.println("recursion lis:"+lis);
    }

    private static int lis(int idx, int prev, int[] a){
        if(idx==a.length) return 0;

        int notTake = lis(idx+1, prev, a);
        int take = Integer.MIN_VALUE;
        if(prev ==-1 || a[idx]>a[prev])
            take = lis(idx+1, idx, a) + 1;

        return Math.max(notTake, take);
    }
}
