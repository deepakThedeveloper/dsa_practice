package recursion;

public class TriangleTraverse {
    public static void main(String[] args) {
        int[][] mat = {{1},{1,3},{3,6,7},{8,9,6,8}};
        int minCost = minPathTraversal(mat, 0, 0, 0);
        System.out.println("min cost recursion:"+minCost);
    }

    private static int minPathTraversal(int[][] mat, int sr, int sc, int level){
        if(sr>=mat.length || sc>=mat[level].length || level >= mat.length) return Integer.MAX_VALUE;
        if(sr == mat.length-1) return mat[sr][sc];

        int downTraversal = minPathTraversal(mat, sr+1, sc, level+1);
        int diagonalTraversal = minPathTraversal(mat, sr+1, sc+1, level+1);

        return Math.min(downTraversal, diagonalTraversal) + mat[sr][sc];
    }
}
