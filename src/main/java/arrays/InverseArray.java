package arrays;

import java.util.Arrays;

public class InverseArray {
    public static void main(String[] args) {
        int[] a = {3,2,1,5,4};
        Arrays.stream(a).forEach(System.out::print);

        System.out.println();
        // I have values at particular index, but I need place the values in their appropriate index, e,g: 4 is at 1
        // but we need 4 at 4th index
        long num = 0l;
        for(int i=1; i<=a.length; i++){
            long val =  a[i-1]*(long)Math.pow(10, i-1);
            System.out.println("i:"+i+" a[i]:"+a[i-1]+" val:"+val);
            num += val;
        }
        System.out.println(num);
    }

}
