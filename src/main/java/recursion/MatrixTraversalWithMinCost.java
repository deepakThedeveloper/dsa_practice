package recursion;

public class MatrixTraversalWithMinCost {
    public static void main(String[] args) {
        int[][] mat = {{2,0,2},{3,2,1},{4,1,3}};
        int minCost = minCostTraversal(mat, 0, 0);
        System.out.println("min cost :"+minCost);
    }

    private static int minCostTraversal(int[][] mat, int sr, int sc) {
        if (sr == mat.length - 1 && sc == mat[0].length - 1) {
            return mat[sr][sc];
        }
        if (sr >= mat.length || sc >= mat[0].length) return Integer.MAX_VALUE;

        int rightTraverse = minCostTraversal(mat, sr, sc + 1);
        int downTraverse = minCostTraversal(mat, sr + 1, sc);

        return Math.min(rightTraverse, downTraverse) +  mat[sr][sc];
    }
}
