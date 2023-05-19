package recursion;

import linked_list.Node1;

public class LinkedListPalindrome {
    static Node1 temp;
    public static void main(String[] args) {
        Node1 head  = getFirstNode();
        temp = head;
        boolean isPalindrome = palindromeCheck(head);
        System.out.println();
        System.out.println(isPalindrome);
    }

    private static boolean palindromeCheck(Node1 head) {
        if(head == null) return true;

        boolean isPlaindrome = palindromeCheck(head.next);
        if(!isPlaindrome || head.val != temp.val) return false;
        else {
            temp = temp.next;
            return true;
        }

    }

    private static Node1 getFirstNode() {
        Node1 node1 = new Node1(0);
        Node1 node2 = new Node1(4, node1);
        Node1 node3 = new Node1(3, node2);
        Node1 node4 = new Node1(22, node3);
        Node1 node5 = new Node1(35, node4);
        Node1 node6 = new Node1(23, node5);
        Node1 node7 = new Node1(35, node6);
        Node1 node8 = new Node1(22, node7);
        Node1 node9 = new Node1(3, node8);
        Node1 node10 = new Node1(4, node9);
        Node1 head1 = new Node1(0, node10);
        Node1 temp = head1;

        while(head1!=null){
            System.out.print(head1.val+"  ");
            head1 = head1.next;
        }

        return temp;
    }

}
