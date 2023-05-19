package stacks;

import java.util.Scanner;
import java.util.Stack;

public class StackOperationMinValue {
    static Stack<Integer> original = new Stack<>();
    static Stack<Integer> minimum = new Stack<>();

    public static void main(String[] args) {
        int[] a = {5,4,8,2,6,1,3,0};
        fillStack(a);
        System.out.println("original size:"+original.size());
        System.out.println("minimum size:"+minimum.size());

        while(original.size() >0){
            System.out.println("original pop:"+original.pop() +" min:"+minimum.pop());
        }
    }
    private static void fillStack(int[] a) {
        original.push(a[0]);
        minimum.push(a[0]);
        for(int i=1; i<a.length; i++){
            original.push(a[i]);
            if(!minimum.isEmpty() && minimum.peek() > a[i]){
                minimum.push(a[i]);
            }
            else {
                minimum.push(minimum.peek());
            }
        }
    }
}
