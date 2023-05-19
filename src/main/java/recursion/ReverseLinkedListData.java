package recursion;

import linked_list.Node1;

//10,20,30,40,50
//50,40,30,20,10
public class ReverseLinkedListData {
    public static void main(String[] args) {
        Node1 head =  getFirstNode();

        Node1 temp = head;
        Node1 temp2 = reverseLinkedListData(temp);
        System.out.println();
        while(head!=null){
            System.out.print(head.val+"  ");
            head = head.next;
        }
    }

    private static Node1 reverseLinkedListData(Node1 temp) {
        if(temp.next.next == null) return temp;
        Node1 swapped = reverseLinkedListData(temp.next);
        int temp1 = swapped.val;
        swapped.val = temp.val;
        temp.val = temp1;

        return temp;
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
        Node1 temp = head;

        while(head!=null){
            System.out.print(head.val+"  ");
            head = head.next;
        }

        return temp;
    }

}
