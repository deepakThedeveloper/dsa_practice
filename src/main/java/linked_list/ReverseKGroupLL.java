package linked_list;

import javafx.util.Pair;
import lombok.AllArgsConstructor;

public class ReverseKGroupLL {
    public static void main(String[] args) {
        Node1 node1 = Util.getSinglyLinkedList(8);
        int k = 3;
        int size = 8; // assume you have traversed list and find its size;
        int group  = size / k;
        Node1 newHead = reverse(node1, k, group);
        Util.traverseSingly(newHead);
    }

    private static Node1 reverse(Node1 n1, int k, int group){
        if(n1==null){
            return null;
        }
        if(group == 0){
            return n1;
        }
        Data data = reverseTillK(n1, k);
        data.end.next = reverse(data.next, k, group-1);
        return data.start;
    }


    private static Data reverseTillK(Node1 n1, int k){
        Node1 c1 = n1, dummy = null;

        while (c1 != null && k>0){
            Node1 forward = c1.next;
            c1.next = dummy;
            dummy = c1;
            c1 = forward;
            k--;
        }
        return new Data(dummy, n1, c1);
    }

    @AllArgsConstructor
    static class Data{
        Node1 start;
        Node1 end;
        Node1 next;
    }
}
