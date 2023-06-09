package dynamicProgramming.catalan;

public class CountMountainsAndValleys {
    public static void main(String[] args) {
        int strokes = 3;
        int[] dp = CatalanNumber.catalanNumber(strokes);
        System.out.println(dp[strokes]);
    }
}
