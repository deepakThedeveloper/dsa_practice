package linked_list;

public class ReverseLinkedList {
    static Node1 oldHead;
    static Node1 newHead = null;

    public static void main(String[] args) {
        Node1 node = Util.getSinglyLinkedList(6);
        Util.traverseSingly(node);

//        oldHead = node;
//        reverseLinklistByLinks(node);
//        Util.traverseSingly(node);
//
//        reverseValues(node);
//        Util.traverseSingly(node);

        Node1 newNode = reverseLLByLinkBetterApproach(node);
        Util.traverseSingly(newNode);
    }

    public static Node1 reverseLinklistByLinks(Node1 node){
      //  Util.traverseSingly(node);
        reverseLinks(node, null);
       // Util.traverseSingly(newHead);
        return newHead;
    }

    private static Node1 reverseLLByLinkBetterApproach(Node1 head){
        Node1 cur = head;
        Node1 prev = null;
        while (cur!=null){
            Node1 forward = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forward;
        }
        return prev;
    }

    private static Node1 reverseLinks(Node1 node, Node1 prev){
        if(node == null){
            newHead = prev;
            return prev;
        }
        reverseLinks(node.next, node).next = prev;
        return prev;
    }

    private static boolean reverseValues(Node1 node){
        if(node == null){
            return true;
        }
        boolean swap = reverseValues(node.next);
        if(swap && oldHead != node && node.next != oldHead){
            int temp = oldHead.val;
            oldHead.val = node.val;
            node.val = temp;
            oldHead = oldHead.next;

            return true;
        }
        return false;
    }
}
