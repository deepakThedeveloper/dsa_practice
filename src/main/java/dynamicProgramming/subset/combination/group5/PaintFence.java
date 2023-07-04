package dynamicProgramming.subset.combination.group5;

import matrix.Util;

//paint n fences in k colors such that not more than 2 consecutive fence has same color. print all such ways
public class PaintFence {
    public static void main(String[] args){
        int fences = 4, colors = 3;
        int paintWays = paintFences(fences, colors);
        System.out.println(paintWays);
    }


    //refer: /resources/paint_fence.jpg
    private static int paintFences(int fences, int colors){
        // 2 rows. 1st row represents count of combinations of painting fence such that last 2 consecutive fence has same color
        // 2nd row represents  count of combinations of painting fence such that last 2 consecutive fence has different color
        // fences represent column
        int[][] dp = new int[2][fences];

        dp[0][0] = 0;
        dp[1][0] = colors;

        for(int j=1; j<fences; j++){
            //1st row represent ii(last 2 same color). so taking not same of previous row and adding same color as last its color
            dp[0][j] = dp[1][j-1];
            // taking total of same and not same and multiplying it by k-1 colors, because if I multiply it with k then
            // last two colors will be same and we want in not same section last two colors to be different so multiplying it by
            // colors(k) - 1;
            dp[1][j] = (dp[0][j-1] + dp[1][j-1]) * (colors-1);
        }
        Util.printMatrix(dp);
        return dp[1][fences-1];
    }
}
