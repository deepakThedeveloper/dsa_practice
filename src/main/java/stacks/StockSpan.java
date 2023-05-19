package stacks;

import java.util.Arrays;
import java.util.Stack;

// stock span means if there is some value at and index(n) which is smaller than value to its any left index(k)
// then difference between index n-k is the stock span, else current index+1 is its span
//eg.: 1,2,4,3,2,5,2,3,1  span[] = {1,2,3,1,1,6,1,2,1}
public class StockSpan {
    public static void main(String[] args) {
        int[] a = {1,2,4,3,2,5,2,3,1};
        int[] span = findStockSpan(a, a.length);

        Arrays.stream(span).forEach(v -> System.out.print(v+" "));
    }

    private static int[] findStockSpan(int[] a, int n) {
        Stack<Integer> indexes = new Stack<>();
        int[] span = new int[n];

        indexes.push(0);
        span[0] = 1;
        for(int i=1; i<n; i++){
            while (indexes.size() > 0 && a[i] > a[indexes.peek()]){
                indexes.pop();
            }
            if(indexes.size() == 0){
                span[i] = i+1;
            }
            else{
                span[i] = i-indexes.peek();
            }
            indexes.push(i);
        }
        return span;
    }
}
