package arrays;

public class FirstSingleElementFromOtherTwiceElement {
    public static void main(String[] args){
        int[] a = {1,2,3,4,1,3,2};

        int xor = 0;
        for(int i=0; i<a.length; i++){
            xor = xor ^ a[i]; // 0 ^ any number = any number. number(n) ^ number(n) = 0
        }

        System.out.println(xor);
    }
}
