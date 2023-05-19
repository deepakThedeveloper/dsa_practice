package linked_list;

//some minor correction is needed
public class AddTwoLinkedListValues {
    public static void main(String[] args) {
        Node1 n1 = getLL1();
        Node1 n2 = getLL2();

        int finalNode = add(n1, n2, 4, 2);
        Node1 node11 = new Node1(finalNode);
        Node1 temp = head.next;
        head.next = node11;
        node11.next = temp;
        while(head!=null){
            System.out.print(head.val+"-->");
            head = head.next;
        }
    }

    static Node1 node1, head;
    private static int add(Node1 n1, Node1 n2, int k1, int k2){
        if(k1==0 && k2==0) return 0;

        int rtn=0, n1Val=0, n2Val=0;
        if(k1>k2) {
            rtn = add(n1.next, n2, k1-1, k2);
            n1Val = n1.val;
        }
        else if(k2 > k1){
            rtn = add(n1, n2.next, k1, k2-1);
            n2Val = n2.val;
        }
        else{
            rtn = add(n1.next, n2.next, k1-1, k2-1);
            n1Val = n1.val;
            n2Val = n2.val;
        }

        int val = n1Val + n2Val + rtn;

        Node1 node2 = new Node1(val%10);
        node2.next = head;
        head = node2;

        return val/10;
    }

    private static Node1 getLL1(){
        Node1 n1 = new Node1(9);
        Node1 n2 = new Node1(7);
        Node1 n3 = new Node1(8);
        Node1 n4 = new Node1(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        return n1;
    }
    private static Node1 getLL2(){
        Node1 n1 = new Node1(7);
        Node1 n2 = new Node1(8);

        n1.next = n2;

        return n1;
    }
}
