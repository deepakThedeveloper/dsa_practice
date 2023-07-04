package linked_list;

//https://leetcode.com/problems/reorder-list/description/
public class ReorderList {
    static Node1 tempHead;

    public static void main(String[] args){
        Node1 head = Util.getSinglyLinkedList(5);
        tempHead = head;
        reorder(head);
    }

    private static boolean reorder(Node1 node){
        if(node == null) return true;

        boolean canContinue = reorder(node.next);
        if(!canContinue) return false;

        if(tempHead.next == node || tempHead == node){
            node.next = null;
            return false;
        }
        node.next = tempHead.next;
        tempHead.next = node;
        tempHead = node.next;

        return canContinue;
    }
}
