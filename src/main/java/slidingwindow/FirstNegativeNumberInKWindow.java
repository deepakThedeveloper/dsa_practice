package slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInKWindow {
    public static void main(String[] args) {
        int[] a = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0, j=0; j<a.length; j++){
            if(j-i<k && a[j]<0){
                queue.add(j);
            }
            if(j-i+1==k){
                if(queue.isEmpty()) System.out.println(0);
                else if(queue.peek() > i) System.out.println(a[queue.peek()]);
                else System.out.println(a[queue.poll()]);
                i++;
            }
        }
    }
}
