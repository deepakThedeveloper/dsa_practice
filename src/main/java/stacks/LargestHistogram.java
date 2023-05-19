package stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        //int[] a = {6,2,5,4,5,1,6};
        int[] a = {5,4,3,4,5};
        int largestArea = findLargestRectangleArea(a, a.length);
        System.out.println();
        System.out.println(largestArea);
    }

    private static int findLargestRectangleArea(int[] a, int n) {
        int[] lBound = getLBoundValues(a, n);
        int[] rBound = getRBoundValues(a, n-1);

        for(int i=0; i<n; i++){

        }
        Arrays.stream(lBound).forEach(v-> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(rBound).forEach(v-> System.out.print(v+" "));
        return 0;
    }

    private static int[] getRBoundValues(int[] a, int n) {
        int[] rBound = new int[n+1];
        Stack<Integer> st = new Stack<>();
        st.push(n);
        rBound[n] = 1;
        for(int i=n-1; i>=0; i--){
            while (!st.isEmpty() && a[i] < a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rBound[i] = n-i;
            }
            else{
                rBound[i] = st.peek() - i;
            }
            st.push(i);
        }
        return rBound;
    }

    private static int[] getLBoundValues(int[] a, int n) {
        int[] lBound = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        lBound[0] = 1;
        for(int i=1; i<n; i++){
            while (!st.isEmpty() && a[i] < a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                lBound[i] = i+1;
            }
            else{
                lBound[i] = (i - st.peek());
            }
            st.push(i);
        }

        return lBound;
    }
}