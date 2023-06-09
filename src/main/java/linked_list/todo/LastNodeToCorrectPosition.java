package linked_list.todo;

import com.sun.security.auth.UnixNumericGroupPrincipal;
import linked_list.Node1;

//todo
public class LastNodeToCorrectPosition {
    public static void main(String[] args) {

    }

    private static Node1 placeLastPointerToProperPosition(Node1 node){
        Node1 cur = node, prev = node;
        while(cur.next!=null){
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;
        Node1 lp = cur;

        Node1 before = new Node1(-1);

        if(node.val > lp.val){
            lp.next = node;
            node = lp;
        }
        else{
            before.next = cur;
        }
        cur = node.next;
        prev = null;
        while(cur!=null){
            if(cur.val > lp.val){
                prev = cur;
                cur = cur.next;
            }
            else{
                prev.next = cur.next;
                if(before.next == null){
                    cur.next = lp;
                    before.next = cur;
                    before = before.next;
                }
                else {
                    cur.next = before.next;
                    before.next = cur;
                }
                cur = prev.next;
            }
        }
        return null;
    }
}
