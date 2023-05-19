package linked_list;

public class AddingOne {
    public static void main(String[] args) {
        Node1 node2 = new Node1(9);
        Node1 node1 = new Node1(9, node2);
        Node1 head = new Node1(9, node1);

        Node1 newNode = addOne(head, head);
        while(newNode!=null){
            System.out.print(newNode.val+"-->");
            newNode  = newNode.next;
        }
    }

    static int quo = 0;
    private static Node1 addOne(Node1 node, Node1 head) {
        if(node == null) {
            return null;
        }
        Node1 node1 = addOne(node.next, head);
        if(node1 == null) {
            quo = addValue(node, 1);
        }
        else {
            if(quo > 0){
                quo = addValue(node, quo);
            }
        }
        if(node == head){
            if(quo > 0){
                Node1  newHead = new Node1(quo);
                newHead.next = head;
                return newHead;
            }
        }

        return node;
    }

    private static int addValue(Node1 node, int val){
        int val1 = node.val+val;
        node.val = val1 %10;
        if(val1<10){
            return 0;
        }
        return val1/10;
    }
}
