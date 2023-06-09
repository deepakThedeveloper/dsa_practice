package linked_list;

public class PalindromicLinkedList {
    public static void main(String[] args) {
        Node1 oddPalindrome = getLLOdd();

        System.out.println("odd palindrome:"+isPalindrome(oddPalindrome));
        Node1 evenPalindrome = getLLEven();
        System.out.println("even palindrome:"+isPalindrome(evenPalindrome));

        Node1 notPalindrome = getLLNotPalindrome();
        System.out.println("not palindrome:"+isPalindrome(notPalindrome));
    }

    private static Node1 getLLOdd() {
        Node1 n5 = new Node1(1);
        Node1 n4 = new Node1(2, n5);
        Node1 n3 = new Node1(3, n4);
        Node1 n2 = new Node1(2, n3);
        Node1 n1 = new Node1(1, n2);
        return n1;
    }

    private static Node1 getLLEven() {
        Node1 n5 = new Node1(1);
        Node1 n4 = new Node1(2, n5);
        Node1 n3 = new Node1(3, n4);
        Node1 n2 = new Node1(3, n3);
        Node1 n1 = new Node1(2, n2);
        Node1 n0 = new Node1(1, n1);

        return n0;
    }

    private static Node1 getLLNotPalindrome() {
        Node1 n5 = new Node1(5);
        Node1 n4 = new Node1(4, n5);
        Node1 n3 = new Node1(3, n4);
        Node1 n2 = new Node1(3, n3);
        Node1 n1 = new Node1(2, n2);
        Node1 n0 = new Node1(1, n1);

        return n0;
    }

    private static boolean isPalindrome(Node1 n1){
        Node1 fast = n1, slow = n1;
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = slow.next;
        Node1 dummy = n1, n2 = ReverseLinkedList.reverseLinklistByLinks(slow);
        while(n2!=null){
            // we can check both nods are same or values. As I have created LL based on
            //values so checking values
            if(dummy.val != n2.val) return false;
            n2 = n2.next;
            dummy = dummy.next;
        }
        return true;
    }
}
