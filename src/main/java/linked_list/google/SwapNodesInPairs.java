package linked_list.google;

import linked_list.Node1;
import linked_list.Util;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapNodesInPairs {
    public static void main(String[] args){
        Node1 node1 = Util.getSinglyLinkedList(4);
        Node1 newHead = swapPairs(node1);

    }

    public static Node1 swapPairs(Node1 head) {
        if(head == null || head.next == null) return head;

        Node1 p1 = head, p2 = head.next;
        Node1 dummy = null;
        //dummy.next = head;
        while(p2!=null){
            p1.next = p2.next;
            p2.next = p1;
            if(dummy == null) head = p2;
            else{
                dummy.next = p2;
            }
            dummy = p1;
            p1 = p1.next;
            p2 = p1 == null ? null : p1.next;
        }
        return head;
    }
}
