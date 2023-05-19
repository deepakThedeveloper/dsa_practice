package other;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.PriorityQueue;

@AllArgsConstructor
@Getter
class Node
{
    int data;
    Node next;
}

public class MergeKSortedLinkedList {
    public static void main(String[] args) {
        System.out.println("in main.............");
        Node node7 = new Node(7, null);
        Node node5 = new Node(5, node7);
        Node node3 = new Node(3, node5);
        Node node1 = new Node(1, node3);

        Node node8 = new Node(8, null);
        Node node6 = new Node(6, node8);
        Node node4 = new Node(4, node6);
        Node node2 = new Node(2, node4);

        Node node11 = new Node(11, null);
        Node node10 = new Node(10, node11);
        Node node9 = new Node(9, node10);
        Node node0 = new Node(0, node9);

        Node arr[] = {node1, node2, node0};

        mergeLinkedList(arr, arr.length);
    }

    private static void mergeLinkedList(Node[] arr, int length) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.data));
        for(Node node : arr){
            priorityQueue.add(node);
        }

        Node result = null;
        Node head = null;
        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            if(result == null){
                result = node;
                head = result;
            }
            else{
                result.next = node;
                result = result.next;
            }
            if(node.next !=null) {
                priorityQueue.add(node.next);
            }
        }

        while(head!=null){
            System.out.print(head.data+"-->");
            head = head.next;
        }
    }
}
