package recursion;

public class PrintArrayElements {
    public static void main(String[] args) {
        int[] a = {2,3,5,7};
        printElements(a, 0);
    }

    private static void printElements(int[] a, int i) {
        if(a.length == i) return;
        System.out.print(a[i]+" ");
        printElements(a,++i);
    }
}
