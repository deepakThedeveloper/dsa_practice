package stacks.todo;

import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        //int[] a = {6,2,5,4,5,1,6};
        int[] a = {2,1,5,6,2,3};
        int largestArea = findMaxRectangleAreaInHistogram(a);
        System.out.println();
        System.out.println(largestArea);
    }

    public static int findMaxRectangleAreaInHistogram(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int n = a.length;
        for(int i=0; i<=n; i++){
            while (!stack.isEmpty() && (i==n || a[stack.peek()] >= a[i])){
                int ht = a[stack.pop()];
                int width;
                if(stack.isEmpty()) width = i;
                else width = i-stack.peek()-1;
                maxArea = Math.max(maxArea, width*ht);
            }
            stack.push(i);
        }
        return maxArea;
    }
}