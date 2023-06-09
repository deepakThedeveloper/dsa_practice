package linked_list;

// Apply merge sort on unsorted linked list
//Todo
public class MergeSortOnLinkedList {

    public static void main(String[] args) {
        Node1 head = getFirstNode();
       /* Node1 tempHead = head;
        while(tempHead!=null){
            System.out.print(tempHead.val+"-->");
            tempHead = tempHead.next;
        }*/
        System.out.println();
        Node1 newNode = mergeSortOnLinkedList(head, null);
        while(newNode!=null){
            System.out.print(newNode.val+" --> ");
            newNode = newNode.next;
        }
    }

    private static Node1 mergeSortOnLinkedList(Node1 head, Node1 tail) {
        if(head == tail) {
            //System.out.println("head value:"+head.val);
            return head;
        }
        Node1 mid = getMidOfLinkedList(head, tail);
        Node1 leftList = mergeSortOnLinkedList(head, mid);
        Node1 rightList = mergeSortOnLinkedList(mid.next, tail);

        if(leftList != null && rightList !=null) {
            Node1 newNode =  MergeTwoSortedLinkedList.mergeSortedLinkedListIteration(leftList, rightList);
        }
        return null;
    }

    private static Node1 getMidOfLinkedList(Node1 head, Node1 tail) {
        Node1 fast = head;
        Node1 slow = head;

        while(fast.next !=tail && fast.next.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
            //System.out.println(fast.val+"  "+ slow.val);
        }
        return slow;
    }


    private static Node1 getFirstNode() {
        Node1 node1 = new Node1(0);
        Node1 node2 = new Node1(4, node1);
        Node1 node3 = new Node1(3, node2);
        Node1 node4 = new Node1(22, node3);
        Node1 node5 = new Node1(35, node4);
        Node1 node6 = new Node1(3, node5);
        Node1 node7 = new Node1(103, node6);
        Node1 node8 = new Node1(7, node7);
        Node1 node9 = new Node1(9, node8);
        Node1 head = new Node1(14, node9);

        return head;
    }
}
