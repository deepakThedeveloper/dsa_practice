package dynamicProgramming.matrices;

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] a = new int[2][2];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++) {
                a[i][j] = 0;
            }
        }
        int ways = getTotalUniquePathsREcursion(a, 0, 0);
        System.out.println("recursion:"+ways);
//
//        System.out.println("===========================================");
        int[][] dp = new int[a.length+1][a[0].length+1];
        for(int i=0; i<a.length+1; i++){
            for(int j=0; j<a[0].length+1; j++) {
                dp[i][j] = -1;
            }
        }
        int ways1 = getTotalUniquePathsMemoization(a, 0, 0, dp);
        System.out.println("ways1 memoization:"+ways1);
       // printMatrix(dp);
        System.out.println();

        int ways2 = getTotalUniquePathsTabulation(a);
        System.out.println("ways2 tabulation:"+ways2);
        int ways3 = uniquePathWaysTabulationRevision(a);
        System.out.println("ways3 tabulation:"+ways3);
    }

    private static  void printMatrix(int[][] dp){
        System.out.println();
        int r = dp.length;
        int c = dp[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getTotalUniquePathsREcursion(int[][] a, int r, int c) {
        if(r==a.length || c==a[0].length) return 0;
        if(r== a.length-1 && c==a[0].length-1) return 1;

        System.out.println("r:"+r+" c:"+c);
        int l1 = getTotalUniquePathsREcursion(a, r, c+1);
        int r1 = getTotalUniquePathsREcursion(a, r+1, c);

        return l1+r1;
    }

    private static int getTotalUniquePathsMemoization(int[][] a, int r, int c, int[][] dp) {
        if(r==a.length || c==a[0].length) return 0;
        if(r== a.length-1 && c==a[0].length-1) return 1;

        if(dp[r][c]!=-1){
            return dp[r][c];
        }
        int l1 = getTotalUniquePathsMemoization(a, r, c+1, dp);
        int r1 = getTotalUniquePathsMemoization(a, r+1, c, dp);

        return dp[r][c] = l1+r1;
    }

    //working code
    private static int uniquePathWaysTabulationRevision(int[][] mat){
        int rlen = mat.length;
        int clen = mat[0].length;

        int[][] dp = new int[rlen][clen];
        dp[rlen-1][clen-1] = 1;

        for(int row = rlen-1; row>=0; row--){
            for(int col = clen-1; col>=0; col--){
                if(row==rlen-1 && col==clen-1) continue;
                int colUpdate = col < clen-1 ? dp[row][col+1]:0;
                int rowUpdate = row < rlen-1 ? dp[row+1][col]:0;

                dp[row][col] = colUpdate + rowUpdate;
            }
        }
        printMatrix(dp);
        return dp[0][0];
    }

    //not working code
    private static int getTotalUniquePathsTabulation(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        int[][] dp = new int[r][c];

        printMatrix(dp);
        for(int i=r-1; i>=0; i--){
            for(int j=c-1; j>=0; j--){
                if(i+1 == r || j+1 == c) continue;
                if(i == r-1 && j == c-1){
                    dp[r-1][c-1] = 1;
                }
                else {
                    int l1 = dp[i][j + 1];
                    int r1 = dp[i + 1][j];
                    dp[i][j] = l1+r1;
                }
            }
        }
       // printMatrix(dp);

        return dp[0][0];
    }
}
