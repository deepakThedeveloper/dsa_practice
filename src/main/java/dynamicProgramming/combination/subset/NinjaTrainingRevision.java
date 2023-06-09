package dynamicProgramming.combination.subset;

public class NinjaTrainingRevision {
    public static void main(String[] args) {
        int[][] mat = {{1,50,10}, {11,100,2}, {6,2,3}};
        int[][] dp =  new int[mat.length][3];
        for(int i = 0; i< dp.length; i++){
            for(int j = 0; j<3; j++){
                dp[i][j] = -1;
            }
        }
        int maxPoints = trainMemoization(mat, 0, mat.length-1, dp);
        printMatrix(dp);
        System.out.println("max points:"+maxPoints);

        System.out.println();
        int maxPoints1 = trainTabulation(mat);
        System.out.println("max points:"+maxPoints1);
    }

    private static void printMatrix(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    //todo:
    private static int trainTabulation(int[][] mat){
        int n = mat.length;
        int[][] dp = new int[n][3];

        int max = Integer.MIN_VALUE;
        int col = 0;
        for(int j=0; j<3; j++){
            if(mat[0][j] > max) {
                col = j;
                max = mat[0][j];
            }
        }
        dp[0][col] = max;

        int prev = col;
        for(int i=1; i<n; i++){
            for (int k = 0; k < 3; k++) {
                if(k==prev)continue;
                int a = dp[i-1][k] + mat[i][k];
                if(a>max) {
                    dp[i][k] = max = a;
                    prev = k;
                }
            }
        }
        printMatrix(dp);
        return dp[n-1][2];
    }

    private static int trainMemoization(int[][] mat, int c, int j, int[][] dp){
        if(j == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<3; i++){
                if(i==c) continue;
                max = Math.max(max, mat[j][i]);
            }
            return max;
        }
        if(dp[j][c]!=-1) return dp[j][c];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i==c)continue;;
            int a = trainMemoization(mat, i, j-1, dp) + mat[j][i];
            max = Math.max(max, a);
        }
        return dp[j][c] = max;
    }

}
