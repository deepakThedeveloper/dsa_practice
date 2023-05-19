package linked_list;

public class Node1 {
    public int val;
    public Node1 next;

    public Node1(int val) {
        this(val, null);
    }

    public Node1(int val, Node1 next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1(2);
        Node1 node2 = node1;

        System.out.println(node1.val+" "+ node2.val);
        changeValue(node1);
        System.out.println(node1.val+" "+ node2.val);

    }

    private static void changeValue(Node1 node1) {
        node1.val = 3;
    }
}
