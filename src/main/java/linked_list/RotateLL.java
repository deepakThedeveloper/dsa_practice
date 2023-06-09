package linked_list;

public class RotateLL {
    public static void main(String[] args) {
        Node1 node = Util.getSinglyLinkedList(7);
        Util.traverseSingly(node);

        int length = 7; //assume you have calculated length of LL
        Node1 newHead = rotateByK(node, 11, length);
        Util.traverseSingly(newHead);
    }

    private static Node1 rotateByK(Node1 n1, int k, int length){
        if(n1 == null || n1.next == null) return n1;

        k = k%length;
        Node1 p1 = n1, p2=n1, c1 = n1;

        for(int i=0; i<k; i++){
            p2 = p2.next;
        }

        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        Node1 temp = p1.next;
        p1.next = null;
        p2.next = c1;
        n1 = temp;

        return n1;
    }
}
