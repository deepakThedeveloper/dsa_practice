package recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        int survivor = getSurvivor(n, k);
        System.out.println(survivor);
    }

    private static int getSurvivor(int n, int k) {
        if(n==1){
            return 0;
        }
        int x = getSurvivor(n-1, k);
        int y = (x+k)%n;

        return y;
    }
}
