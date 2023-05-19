package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreatestNumber {
    public static void main(String[] args) {
        int[] a = {2,5,9,3,1,4,12,6,8,7};
        long[] val = new long[a.length];
        for(int i=0; i<a.length; i++){
            val[i] = -1;
        }
        //intList.forEach(v-> System.out.print(v+" "));
        findNumber(a, a.length-1, val);
        System.out.println();
        Arrays.stream(val).forEach(v-> System.out.print(v+" "));
    }

    private static void findNumber(int[] a, int n, long[] intList) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(a[n]);
        for(int i=n-1; i>=0; i--){
            if(a[i]<a[i+1]){
                intList[i] = a[i+1];
            }
            else{
                while(!integerStack.isEmpty()) {
                    int element = integerStack.pop();
                    if (a[i] < element) {
                        integerStack.push(element);
                        intList[i] = element;
                        break;
                    }
                }
            }
            integerStack.push(a[i]);
        }
    }
}
