package dynamicProgramming.subset.combination.group5;

import matrix.Util;

public class PaintHouse {
    public static void main(String[] args){
        int[][] paint = {
                {1, 5, 3, 1},
                {5, 8, 2, 2},
                {7, 4, 9, 4}
        };
        int minPrice = minPrice(paint);
        System.out.println(minPrice);
    }

    private static int minPrice(int[][] paint){
        int colors = paint.length; // 3 colors 3 rows
        int houses = paint[0].length; //4 houses 4 cols
        int[][] dp = new int[colors][houses];

        for(int r=0; r<colors; r++){
            dp[r][0] = paint[r][0];
        }

        int minPrice = Integer.MAX_VALUE;
        for(int i=1; i<houses; i++){
            minPrice = Integer.MAX_VALUE;
            for(int j=0; j<colors; j++){
                int minVal = Integer.MAX_VALUE;
                for(int k=0; k<colors; k++){
                    // excluding current color value of previous house. e.g. if painting red for current house then excluding red of
                    // previous house
                    if(j==k) continue;

                    // include min price of other color of previous house
                    minVal = Math.min(minVal, dp[k][i-1]);
                }
                dp[j][i] = minVal + paint[j][i];
                minPrice = Math.min(minPrice, dp[j][i]);
            }
        }
        Util.printMatrix(paint);

        Util.printMatrix(dp);
        return minPrice;
    }
}
