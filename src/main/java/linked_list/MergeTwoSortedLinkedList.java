package linked_list;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node1 firstNode = getFirstNode();
        Node1 secondNode = getSecondNode();


        Node1 newNode = mergeSortedLinkedList(firstNode, secondNode);
        /*while(newNode!=null){
            System.out.print(newNode.val+" --> ");
            newNode = newNode.next;
        }*/
    }

    public static Node1 mergeSortedLinkedList(Node1 firstNode, Node1 secondNode) {
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
        Node1 node1 = new Node1(77);
        Node1 node2 = new Node1(47, node1);
        Node1 node3 = new Node1(35, node2);
        Node1 node4 = new Node1(22, node3);
        Node1 node5 = new Node1(15, node4);
        Node1 node6 = new Node1(12, node5);
        Node1 head = new Node1(10, node6);

        return head;
    }

    private static Node1 getSecondNode() {
        Node1 node1 = new Node1(65);
        Node1 node2 = new Node1(51, node1);
        Node1 node3 = new Node1(47, node2);
        Node1 node4 = new Node1(39, node3);
        Node1 node5 = new Node1(28, node4);
        Node1 node6 = new Node1(25, node5);
        Node1 node7 = new Node1(13, node6);
        Node1 node8 = new Node1(11, node7);
        Node1 head = new Node1(5, node8);

        return head;
    }

}
