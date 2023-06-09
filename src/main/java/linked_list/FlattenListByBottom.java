package linked_list;

public class FlattenListByBottom {
    public static void main(String[] args) {
        NodeRandom first = getLL();

        NodeRandom newHead = flatten(first);
        Util.traverseSingly(newHead);
    }

    private static NodeRandom flatten(NodeRandom n1){
        if(n1.next == null) return n1;
        NodeRandom flattenHead = flatten(n1.next);
        return mergeSortedList(n1, flattenHead);
    }

    private static NodeRandom mergeSortedList(NodeRandom n1, NodeRandom n2){
        NodeRandom dummy = new NodeRandom(-1);
        NodeRandom prev = dummy;
        while(n1!=null && n2!=null){
            if(n1.val < n2.val){
                prev.random = n1;
                n1 = n1.random;
            }
            else{
                prev.random = n2;
                n2 = n2.random;
            }
            prev = prev.random;
        }
        prev.random = n1 == null ? n2 : n1;
        dummy.random.next = null;
        return dummy.random;
    }

    private static NodeRandom getLL(){
        NodeRandom first3 = new NodeRandom(30);
        NodeRandom first2 = new NodeRandom(8, first3);
        NodeRandom first1 = new NodeRandom(7, first2);
        NodeRandom first = new NodeRandom(5, first1);

        NodeRandom second1 = new NodeRandom(20);
        NodeRandom second = new NodeRandom(10, second1);

        NodeRandom third2 = new NodeRandom(50);
        NodeRandom third1 = new NodeRandom(22, third2);
        NodeRandom third = new NodeRandom(19, third1);

        NodeRandom fourth3 = new NodeRandom(45);
        NodeRandom fourth2 = new NodeRandom(40, fourth3);
        NodeRandom fourth1 = new NodeRandom(35, fourth2);
        NodeRandom fourth = new NodeRandom(28, fourth1);

        first.next = second;
        second.next = third;
        third.next = fourth;

        return first;
    }
}


class Node{
    int val;
    NodeRandom next;
    NodeRandom bottom;

    Node(int val, NodeRandom next, NodeRandom bottom){
        this.val = val;
        this.next = next;
        this.bottom = bottom;
    }

    Node(int val, NodeRandom bottom){
        this(val, null, bottom);
    }
    Node(int val){
        this(val, null, null);
    }
}
