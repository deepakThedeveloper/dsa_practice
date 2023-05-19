package recursion;

public class PrintMazePath {
    public static void main(String[] args) {
        printMazePath(0,0, 3,3, "s");
    }

    private static void printMazePath(int sr, int sc, int dr, int dc, String op) {
        if(sr == dr && sc == dc){
            System.out.println(op);
            return;
        }
        if(sr>dr || sc > dc){
            return;
        }
        printMazePath(sr, sc+1, dr, dc, op+'h');
        printMazePath(sr+1, sc, dr, dc, op+'v');
    }
}
