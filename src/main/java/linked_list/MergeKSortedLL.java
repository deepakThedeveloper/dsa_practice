package linked_list;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLL {
    public static void main(String[] args) {
        Node1 first = Util.getSortedList(6, 1);
        Node1 second = Util.getSortedList(4, 2);
        Node1 third = Util.getSortedList(7, 3);

        List<Node1> nodes = Arrays.asList(first, second, third);

//        mergeKSortedLLSameListPriorityQueue(nodes);
        mergeKSortedLLSameListDivideAndConquer(nodes);
    }

    private static void mergeKSortedLLPriorityQueueApproach(List<Node1> headNodes){
        Node1 main = mergeKSortedLLNewList(headNodes);
        Util.traverseSingly(main);
        Node1 main1 = mergeKSortedLLSameListPriorityQueue(headNodes);
        Util.traverseSingly(main1);
    }

    private static void mergeKSortedLLSameListDivideAndConquer(List<Node1> headNodes){
        Node1 newHead = divideAndMerge(headNodes, 0, headNodes.size()-1);
        Util.traverseSingly(newHead);
    }

    private static Node1 divideAndMerge(List<Node1> headNode, int s, int e){
        if(s>e) return null;
        if(s==e) return headNode.get(s);
        int mid = (s+e)/2;

        Node1 first = divideAndMerge(headNode, s, mid);
        Node1 second = divideAndMerge(headNode, mid + 1, e);

        return MergeTwoSortedLinkedList.mergeSortedLLApproach2Better(first, second);
    }

    private static Node1 mergeKSortedLLSameListPriorityQueue(List<Node1> headNodes){
        PriorityQueue<Data> dataQueue = new PriorityQueue<>(Comparator.comparingInt(d->d.val));
        for(int i=0; i<headNodes.size(); i++){
            Node1 node = headNodes.get(i);
            dataQueue.add(new Data(node.val, node));
        }

        Node1 dummy = new Node1(-1);
        Node1 prev = dummy;
        while(!dataQueue.isEmpty()){
            Data cur = dataQueue.poll();
            Node1 ext = prev.next = cur.head;
            if(ext!=null && ext.next!=null) {
                ext = ext.next;
                dataQueue.add(new Data(ext.val, ext));
            }
            prev = prev.next;
        }
        return dummy.next;
    }

    private static Node1 mergeKSortedLLNewList(List<Node1> headNodes){
        PriorityQueue<Data> dataQueue = new PriorityQueue<>(Comparator.comparingInt(d->d.val));
        for(int i=0; i<headNodes.size(); i++){
            Node1 node = headNodes.get(i);
            dataQueue.add(new Data(node.val, node));
        }

        Node1 newHead = null, prev = null;
        while(!dataQueue.isEmpty()){
            Data cur = dataQueue.poll();
            Node1 node1 = new Node1(cur.val);
            if(newHead==null) {
                newHead = node1;
                prev = node1;
            }
            else{
                prev.next = node1;
                prev = prev.next;
            }
            Node1 ext = cur.head;
            if(ext!=null && ext.next!=null) {
                ext = ext.next;
                dataQueue.add(new Data(ext.val, ext));
            }
        }
        return newHead;
    }

    @AllArgsConstructor
    static class Data{
        int val;
        Node1 head;
    }
}
