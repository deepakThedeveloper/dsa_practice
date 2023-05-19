package stacks;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        //9,9,8,14,14,14,14,32,32,32,32,19,19,19
        int[] a = {2,9,3,8,1,7,14,6,12,4,32,0 ,7 ,19,8 ,12,6};
        int k = 4;
        int[] nge = nextGreaterElement(a, a.length-1);
        Arrays.stream(nge).forEach(v-> System.out.print(v+" "));
        System.out.println();
        printSlidingWindowMax(a, a.length, k, nge);
    }

    private static int[] nextGreaterElement(int[] a, int n) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(n);
        int[] nge = new int[n+1];
        for(int i=0; i<=n; i++){
            nge[i] = -1;
        }
        for(int i=n-1; i>=0; i--){
            if(a[i]<a[i+1]){
                nge[i] = i+1;
            }
            else{
                while(!integerStack.isEmpty()) {
                    int element = integerStack.pop();
                    if (a[i] < a[element]) {
                        integerStack.push(element);
                        nge[i] = element;
                        break;
                    }
                }
            }
            integerStack.push(i);
        }
        return nge;
    }

    private static void printSlidingWindowMax(int[] a, int n, int k, int[] nge) {
        for(int i=0, j=0; i<n-k+1; i++){
            if(j<i){
                j=i;
            }
            while(nge[j] != -1 && nge[j]-i<k){
                j=nge[j];
            }
            System.out.print(a[j]+" ");
        }
    }
}
//0,1,2,3,4,5,6 ,7,8 ,9,10,11,12,13,14,15,16
//2,9,3,8,1,7,14,6,12,4,32,0 ,7 ,19,8 ,12,6

// upper - 13

// lower - 14

//9,9,8,12,12,14,14,32,32,32,19,19,19

// two variables upper and lower and set values in it
// compare next element in loop from k+1 with upper and lower
// first compare index of both upper and lower with k+1
// if diff == k of upper
//  if value[k+1] > value[upper] then replace upper with k+1 index
//  else upper = lower and lower  = k+1;
// if diff == k of lower
//  lower = k+1;
// if diff < k
//   value[k+1] < value[upper] -  true then print value[upper]
//    else   upper = k+1 and print value[upper] and lower  = upper