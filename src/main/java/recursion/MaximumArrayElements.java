package recursion;

public class MaximumArrayElements {
    public static void main(String[] args) {
        int[] a= {35,6,1,8,0,7,22};
        int max = findMax(a, a.length-1);
        System.out.println(max);
    }

    // Expectations: compare all elements with each other, max(a[0], a[1]), max(max(a[0],a[1]), a[2])...
    // Faith: my function found max value of max(a[0], a[n-1]).
    // EF: I need to find max(max(a[0], a[n-1]), a[n])
    private static int findMax(int[] a, int n) {
        if(n==0) return a[0];

        int max =  findMax(a, n-1);
        return Math.max(max, a[n]);
    }
}
