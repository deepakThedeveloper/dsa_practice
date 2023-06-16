package arrays;

import java.util.Arrays;

public class Util {

    public static void print1DArray(String msg, int[] a){
        System.out.println("=======================================================");
        System.out.println(msg);
        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
        System.out.println();
        System.out.println("=======================================================");
    }
}
