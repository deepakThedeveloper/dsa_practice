package arrays;

import java.util.PriorityQueue;

//1,2,3,4,5,6,7,
public class SortKSortedArray {
    public static void main(String[] args) {
        int[] a = {2,3,1,4,6,7,5,8,9};
        int k = 6;
        sortKSorted(a,k);
    }

    private static void sortKSorted(int[] a, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<a.length; i++){
            if(queue.size()==k+1){
                System.out.print(queue.remove()+" ");
            }
            queue.add(a[i]);
        }
        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
    }
}
