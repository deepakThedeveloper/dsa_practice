package dynamicProgramming;

// total unique paths to reach from 0,0 to m,n. can move only in right or down direction
public class MovingInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,2}, {0,2,11}, {8,1,1}, {21,5,4}, {8,7,0}};
        //int[][] matrix = {{1,1}, {2,2}};

        //findTotalUniqueWays(matrix);
        findMinCost(matrix);
    }

    private static void findMinCost(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int row = 1; row< matrix.length; row++){
            dp[row][0] = matrix[row][0] + dp[row-1][0];
        }
        for(int col = 1; col< matrix[0].length; col++){
            dp[0][col] = matrix[0][col] + dp[0][col-1];
        }
        int[][] optimalPath = new int[matrix.length][3];
        optimalPath[0][0] = 0;
        optimalPath[0][1] = 0;
        optimalPath[0][2] = matrix[0][0];
        for(int row=1; row<matrix.length; row++){
            for(int col=1; col<matrix[0].length; col++) {
                if(dp[row-1][col] < dp[row][col-1]){
                    dp[row][col] = dp[row-1][col] + matrix[row][col];
                    optimalPath[row][0] = row-1;
                    optimalPath[row][1] = col;
                    optimalPath[row][2] = dp[row-1][col];
                }
                else {
                    dp[row][col] = dp[row][col-1]+ matrix[row][col];
                    optimalPath[row][0] = row;
                    optimalPath[row][1] = col-1;
                    optimalPath[row][2] = dp[row][col-1];
                }
            }
        }
        System.out.println("min cost:"+dp[matrix.length-1][matrix[0].length-1]);

        System.out.println("optimal path:");
        for(int i=0; i< optimalPath.length; i++){
            System.out.println(optimalPath[i][0]+""+optimalPath[i][1]+" -->"+optimalPath[i][2]);
        }
    }

    private static void findTotalUniqueWays(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int row = 0; row< matrix.length; row++){
            dp[row][0] = 1;
        }
        for(int col = 0; col< matrix[0].length; col++){
            dp[0][col] = 1;
        }

        for(int row=1; row<matrix.length; row++){
            for(int col=1; col<matrix[0].length; col++) {
                dp[row][col] = dp[row-1][col]+dp[row][col-1];
            }
        }

        System.out.println("total ways to reach m*n:"+dp[matrix.length-1][matrix[0].length-1]);
    }
}
