package recursion;

public class PrintDecreasingIncreasing {
    public static void main(String[] args) {
        printDecreasingIncreasing(5);
    }

    //Expectation: to print value till x and from x in decreasing and increasing order
    //Faith: my function is already able to print value for (x-1).
    // So, I just need to print value x and rest by invoking print(x-1) my job is done as print(x-1) is already able to print value;
    private static void printDecreasingIncreasing(int i) {
        if(i==0) return;
        System.out.println(i);
        printDecreasingIncreasing(i-1);
        System.out.println(i);
    }
}
