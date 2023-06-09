package linked_list;

public class DetectCycle {
    public static void main(String[] args) {
        Node1 noCycle = Util.getSinglyLinkedList(6);
        boolean isCyclePresent = detectCycle(noCycle);
        System.out.println("no cycle:"+isCyclePresent);

        Node1 cyclePresent = getSinglyLinkedList();
        boolean isCyclePresent1 = detectCycle(cyclePresent);
        System.out.println("cycle:"+isCyclePresent1);
    }

    private static boolean detectCycle(Node1 n1){
        if(n1 == null || n1.next == null) return false;
        Node1 slow = n1, fast = n1;

        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

    private static Node1 getSinglyLinkedList(){
        Node1 n3 = new Node1(3);
        Node1 n6 = new Node1(6, n3);
        Node1 n5 = new Node1(5, n6);
        Node1 n4 = new Node1(4, n5);
        Node1 n2 = new Node1(2, n3);
        Node1 n1 = new Node1(1, n2);
        Node1 n0 = new Node1(0, n1);
        n3.next = n4;

        return n0;
    }
}
