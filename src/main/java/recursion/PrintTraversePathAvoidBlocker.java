package recursion;

/*
ddrrrrdddrr
ddrruurrrrddlldddrr
ddrdddrrrrr
 */
import java.util.HashSet;
import java.util.Set;

public class PrintTraversePathAvoidBlocker {
    public static void main(String[] args) {
       int[][] locations = {{0,1,0,0,0,0,0},{0,1,0,1,1,1,0},{0,0,0,0,0,0,0},{1,0,1,1,0,1,1},{1,0,1,1,0,1,1},{1,0,0,0,0,0,0}};
        //int[][] locations = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,0},{1,0,1,1,0},{1,0,1,1,0},{1,0,0,0,0}};
        //int[][] locations = {{0,1,0,0},{0,1,0,1},{0,0,0,0},{1,0,1,1}};
        printPaths(0,0, 5,6,"",locations);
    }

    static Set<String> traversedCell = new HashSet<>();
    private static void printPaths(int sr, int sc, int dr, int dc, String op, int[][] locations) {
        traversedCell.add(""+sr+sc);
        if(sc == dc && sr == dr){
            System.out.println(op);
            return;
        }
        if(sc<0 || sc > dc || sr<0 || sr>dr || locations[sr][sc] == 1) return;


        if(!traversedCell.contains(""+sr+(sc+1))) {
            printPaths(sr, sc + 1, dr, dc, op + "r", locations);
            traversedCell.remove(""+sr+(sc+1));
        }
        if(!traversedCell.contains(""+(sr+1)+sc)) {
            printPaths(sr + 1, sc, dr, dc, op + "d", locations);
            traversedCell.remove(""+(sr+1)+sc);
        }
        if(!traversedCell.contains(""+sr+(sc-1))) {
            printPaths(sr, sc - 1, dr, dc, op + "l", locations);
            traversedCell.remove(""+sr+(sc-1));
        }
        if(!traversedCell.contains(""+(sr - 1)+ sc)) {
            printPaths(sr - 1, sc, dr, dc, op + "u", locations);
            traversedCell.remove(""+(sr - 1)+ sc);
        }
    }
}
