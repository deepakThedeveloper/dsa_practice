package linked_list;

public class Segregate012 {
    public static void main(String[] args) {
        Node1 head = getLinkedList();
        Util.traverseSingly(head);

        Node1 newHead = segregate012(head);
        Util.traverseSingly(newHead);
    }

    private static Node1 segregate012(Node1 node) {
        Node1 zero = new Node1(-1);
        Node1 p0 = zero;
        Node1 one = new Node1(-1);
        Node1 p1 = one;
        Node1 two = new Node1(-1);
        Node1 p2 = two;

        Node1 cur = node;
        while (cur!=null){
            if(cur.val == 0){
                p0.next = cur;
                p0 = p0.next;
            }
            if(cur.val == 1){
                p1.next = cur;
                p1 = p1.next;
            }
            if(cur.val == 2){
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        p0.next = one.next;
        p1.next = two.next;
        p2.next = null;

        return zero.next;
    }

    private static Node1 getNode1(Node1 prev, Node1 temp, Node1 n1) {
        prev.next = null;
        temp.next = n1.next;
        n1.next = temp;
        n1 = n1.next;
        return n1;
    }

    private static Node1 getLinkedList() {
        Node1 node9 = new Node1(1);
        Node1 node8 = new Node1(0, node9);
        Node1 node7 = new Node1(2, node8);
        Node1 node6 = new Node1(1, node7);
        Node1 node5 = new Node1(0, node6);
        Node1 node4 = new Node1(2, node5);
        Node1 node3 = new Node1(0, node4);
        Node1 node2 = new Node1(1, node3);
        Node1 node1 = new Node1(1, node2);
        Node1 node0 = new Node1(0, node1);

        return node0;
    }
}
