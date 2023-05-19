package arrays;

public class StarTraingle {
    public static void main(String[] args) {
        for(int i=1; i<=5; i++){
            printStar(i,5);
            System.out.println();
        }
    }

    private static void printStar(int s, int k1) {
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
        for(int k = 0; k<s; k++){
            System.out.print("* ");
        }
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
    }
}
