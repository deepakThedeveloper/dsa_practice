package dynamicProgramming.catalan;

//refer:/resources/intersection_chord_catalan.jpg
public class ChordIntersection {
    public static void main(String[] args) {
        int totalPointOnCircle = 6;

        int n = getNValue(totalPointOnCircle);
        int[] dp = CatalanNumber.catalanNumber(n);
        System.out.println(dp[n]);
    }

    // total points on circle need to be even if chords needs to be drawn without intersection
    private static int getNValue(int totalPointsOnCircle){
        if(totalPointsOnCircle == 0) return 0;
        return totalPointsOnCircle/2; //0=0, (totalPoints)2= (catalan N)1, 4=2, 6=3
    }
}
