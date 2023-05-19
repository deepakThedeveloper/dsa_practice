package other;

// 5,10,15,20,25,26,3,1,7,14
// 0,1,3,3,4,5,5,7,7,8,9,10,11,12,14,15,15,19,20,23,25,26,34,43,45,56,66
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Median {
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("insert numeric value");
            //System.out.println();
            int val = Integer.parseInt(bufferedReader.readLine());
            //System.out.println("value inserted:"+val);
            if (val == 99) break;

            System.out.println("original median is:"+findMedian(val));
            System.out.println("revision median is:"+findMedianRevision(val));
        }
    }
    static PriorityQueue<Integer> maxInSmall = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minInLarge = new PriorityQueue<>();

    private static int findMedianRevision(int val){
        if (minInLarge.isEmpty() || val > minInLarge.peek()) {
            minInLarge.add(val);
            int diff = minInLarge.size() - maxInSmall.size();
            if(diff<0 || diff>1){
                maxInSmall.add(minInLarge.poll());
            }
        }
        else if(maxInSmall.isEmpty() || val < minInLarge.peek()){
            maxInSmall.add(val);
            int diff = maxInSmall.size() - minInLarge.size();
            if(diff<0 || diff>1){
                minInLarge.add(maxInSmall.poll());
            }
        }

        System.out.println("revision ---> minInLarge peak:"+minInLarge.peek()+" maxInSmall peak:"+maxInSmall.peek());
        System.out.println("revision ---> minInLarge size:"+minInLarge.size()+" maxInSmall size:"+maxInSmall.size());
        if((minInLarge.size() + maxInSmall.size())%2!=0){
            return maxInSmall.size()>minInLarge.size() ? maxInSmall.peek() : minInLarge.peek();
        }
        else{
            return (minInLarge.peek()+maxInSmall.peek())/2;
        }
    }

    private static int findMedian(int val) {
        insertInHeap(val);
        int totalValues =  minHeap.size() + maxHeap.size();
        System.out.println("original ---> minHeap peak:"+minHeap.peek()+" maxHeap peak:"+maxHeap.peek());

        if(totalValues%2==0) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.size() < minHeap.size() ? minHeap.peek() : maxHeap.peek();
    }

    private static void insertInHeap(int val) {
        if(minHeap.isEmpty()) {
            minHeap.add(val);
        }
        else {
            if(val > minHeap.peek()){
                maxHeap.add(val);
            }
            else {
                minHeap.add(val);
            }
            if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.add(minHeap.poll());
            }
            else if (maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            }
        }
    }
}
