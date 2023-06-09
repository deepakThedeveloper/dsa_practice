package recursion;

import matrix.Util;

public class MaximumGold {
    public static void main(String[] args) {
        int[][] gold = {{1,2,3}, {4,5,6}, {7,8,9}};

        int rlen = gold.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<rlen; i++) {
            int temp = maxGoldRecursionRevision(gold, i, 0);
            max = Math.max(temp, max);
        }
        System.out.println("max profit:"+max);
    }

    private static int maxGoldRecursionRevision(int[][] a, int sr, int sc){
        if(sr >=a.length || sc>=a[0].length || sr<0 || sc<0) return 0;

        if(sr==a.length-1 && sc==a[0].length-1) {
            return a[sr][sc];
        }

        int v1 = maxGoldRecursionRevision(a, sr - 1, sc + 1);
        int v2 = maxGoldRecursionRevision(a, sr, sc + 1);
        int v3 = maxGoldRecursionRevision(a, sr + 1, sc + 1);

        return Math.max(v1, Math.max(v2, v3)) + a[sr][sc];
    }
}
