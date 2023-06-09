package linked_list;

import javafx.util.Pair;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class Person{
    int age;
}
public class FoldLinkedList {
    static Node1 node1;
    public static void main(String[] args) {
        Node1 node = Util.getSinglyLinkedList(6);
        node1 = node;
        System.out.println("original");
        Util.traverseSingly(node);

        foldLLApproach1(node);
        System.out.println("folded");
        Util.traverseSingly(node);

        unfoldLL(node);
    }

    private static boolean foldLLApproach1(Node1 node){
        if(node == null) return false;
        boolean terminate = foldLLApproach1(node.next);

        if(terminate)return true;
        Node1 temp = node1.next;
        node1.next = node;
        node.next = temp;
        node1 = temp;
        if(node1.next == node){
            node1.next = null;
            return true;
        }
        return false;
    }

    private static void unfoldLL(Node1 node){
        Node1 fp, sp, forward = null;
        Node1 head1, head2;
        fp = head1 = node;
        sp = head2 = node.next;
        if(node.next!=null) forward = node.next.next;

        while(fp!=null && sp!=null){
            if(forward == null){
                fp.next = forward;
                break;
            }
            else {
                fp.next = forward;
                sp.next = forward.next;
                fp = forward;
                sp = sp.next;
                if (sp != null) {
                    forward = sp.next;
                }
            }
        }
        fp.next = ReverseLinkedList.reverseLinklistByLinks(head2);
        System.out.println("unfolded");
        Util.traverseSingly(head1);
    }
}
