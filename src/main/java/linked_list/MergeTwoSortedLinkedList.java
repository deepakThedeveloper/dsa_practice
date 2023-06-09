package linked_list;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node1 firstNode = getFirstNode();
        Node1 secondNode = getSecondNode();

        Node1 newHead = mergeSotedLLRecursion(firstNode, secondNode);
        Util.traverseSingly(newHead);

//        Node1 newNode = mergeSortedLinkedListIteration(firstNode, secondNode);
//        Util.traverseSingly(newNode);
    }

    public static Node1 mergeSortedLLApproach2Better(Node1 n1, Node1 n2){
        if(n1==null || n2==null) return n1!=null ? n1 : n2;
        Node1 dummy = new Node1(-1);
        Node1 prev = dummy;
        Node1 c1 = n1, c2 = n2; // best practice to not traverse with head pointers
        while(c1!=null && c2!=null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            }
            else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1!=null ? c1 : c2;
        return dummy.next;
    }
    private static Node1 mergeSotedLLRecursion(Node1 n1, Node1 n2){
        if(n1==null && n2!=null) return n2;
        if(n2==null && n1!=null) return n1;

        if(n1.val < n2.val){
            n1.next = mergeSotedLLRecursion(n1.next, n2);
            return n1;
        }
        else{
            n2.next = mergeSotedLLRecursion(n1, n2.next);
            return n2;
        }
    }

    public static Node1 mergeSortedLinkedListIteration(Node1 firstNode, Node1 secondNode) {
        Node1 p1 = firstNode;
        Node1 p2 = secondNode;

        Node1 sortedNode;
        if(p1.val < p2.val) {
            sortedNode = new Node1(p1.val);
            p1 = p1.next;
        } else{
            sortedNode = new Node1(p2.val);
            p2 = p2.next;
        }
        Node1 head = sortedNode;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                sortedNode.next = new Node1(p1.val);;
                sortedNode = sortedNode.next;
                p1 = p1.next;
            }
            else{
                sortedNode.next = new Node1(p2.val);
                sortedNode = sortedNode.next;
                p2 = p2.next;
            }
        }

        while(p1 != null){
            sortedNode.next = p1;
            p1 = p1.next;
        }

        while(p2 != null){
            sortedNode.next = p2;
            p2 = p2.next;
        }
        return head;
    }

    private static Node1 getFirstNode() {
        Node1 node5 = new Node1(9);
        Node1 node4 = new Node1(7, node5);
        Node1 node3 = new Node1(5, node4);
        Node1 node2 = new Node1(3, node3);
        Node1 node1 = new Node1(1, node2);
        return node1;
    }

    private static Node1 getSecondNode() {
        Node1 node3 = new Node1(6);
        Node1 node2 = new Node1(4, node3);
        Node1 node1 = new Node1(2, node2);
        return node1;
    }
}
