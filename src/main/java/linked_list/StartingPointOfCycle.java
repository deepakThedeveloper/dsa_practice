package linked_list;

public class StartingPointOfCycle {
    public static void main(String[] args) {
        Node1 cyclePresent = getSinglyLinkedListUseCase1();
        Node1 cyclicNode1 = detectCycle(cyclePresent);
        System.out.println("cycle present in middle of list:"+cyclicNode1.val);

        Node1 cyclePresent1 = getSinglyLinkedListUseCase2();
        Node1 cyclicNode2 = detectCycle(cyclePresent1);
        System.out.println("cycle present at start of list:"+cyclicNode2.val);

        Node1 noCycle = Util.getSinglyLinkedList(6);
        Node1 cyclicNode = detectCycle(noCycle);
        System.out.println("no cycle:"+cyclicNode);
    }

    private static Node1 detectCycle(Node1 n1){
        if(n1 == null || n1.next == null) return n1;
        Node1 slow = n1, fast = n1, restart = n1;

        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (restart!=slow){
                    restart = restart.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    //0-1-2-3-4-5-6-3.....
    private static Node1 getSinglyLinkedListUseCase1(){
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

    //0-1-2-3-4-5-6-0
    private static Node1 getSinglyLinkedListUseCase2(){
        Node1 n6 = new Node1(6);
        Node1 n5 = new Node1(5, n6);
        Node1 n4 = new Node1(4, n5);
        Node1 n3 = new Node1(3, n4);
        Node1 n2 = new Node1(2, n3);
        Node1 n1 = new Node1(1, n2);
        Node1 n0 = new Node1(0, n1);
        n6.next = n0;

        return n0;
    }
}
