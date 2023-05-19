package priorityQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MInPriorityQueue {
    public static void main(String[] args) {
        PriorityQueueImpl priorityQueue = new PriorityQueueImpl(new LinkedList());
        priorityQueue.push(4);
        priorityQueue.push(2);
        priorityQueue.push(3);
        priorityQueue.push(1);
    }
}
