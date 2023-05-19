package recursion;

public class ParallelMatrixTraversal {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}, {11,12,13,14}, {21,22,23,24}, {31,32,33,34}};
        int minCost = minPath(mat, 0,0,0,mat[0].length-1);
        System.out.println("min cost:"+minCost);
    }

    private static int minPath(int[][] mat, int i, int aliceJ, int bobJ, int clen){
        if(aliceJ>=clen || aliceJ<0 || bobJ>=clen || bobJ<0) return Integer.MIN_VALUE;
        if(i == mat.length-1){
            if(aliceJ == bobJ) return mat[i][aliceJ];
            return mat[i][aliceJ] + mat[i][bobJ];
        }

        int max = Integer.MIN_VALUE;
        for(int i1=-1; i1<=1; i1++){
            for(int j=-1; j<=1; j++) {
                int value = 0;
                if(aliceJ==bobJ){
                    value = mat[i][aliceJ];
                }
                else{
                    value = mat[i][aliceJ] + mat[i][bobJ];
                }

                value += minPath(mat,  i+1, aliceJ+i1,  bobJ+j, clen);

                max = Math.max(value, max);
            }
        }
        return max;
    }
}
