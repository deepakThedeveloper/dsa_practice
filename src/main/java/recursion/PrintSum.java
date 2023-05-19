package recursion;

public class PrintSum {
    public static void main(String[] args) {
        int sum = addition(5);
        System.out.println(sum);
    }

    private static int addition(int n) {
        if(n==0) return 0;

        int v = addition(n-1);
        System.out.println(v);
        return v+n;
    }
}
