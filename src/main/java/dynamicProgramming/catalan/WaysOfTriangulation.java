package dynamicProgramming.catalan;

//refer:/resources/ways_of_triangulation.jpg
public class WaysOfTriangulation {
    public static void main(String[] args) {
        int shapeSide = 5; // 4 = square, 5 = pentagon, 6=hexagon

        int n = getNValue(shapeSide);
        int[] dp = CatalanNumber.catalanNumber(n);
        System.out.println(dp[n]);
    }

    private static int getNValue(int shapeSide){
        if(shapeSide <= 3) return 1;
        return shapeSide-2;
    }
}
