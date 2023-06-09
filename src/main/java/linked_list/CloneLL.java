package linked_list;


import java.util.LinkedHashMap;

public class CloneLL {
    public static void main(String[] args) {
        NodeRandom original = getLL();
        NodeRandom t1 = original;
        System.out.println("original:======================================");
        while(t1 != null){
            Integer nv = t1.next == null ? null : t1.next.val;
            Integer rv = t1.random == null ? null : t1.random.val;
            System.out.print("val:"+t1.val+" next:"+nv+" random:"+rv);
            t1 = t1.next;
            System.out.println();
        }
        System.out.println("original:======================================");


        NodeRandom newCopy = deepCopyLL(original);
        NodeRandom t2 = newCopy;
        System.out.println("copy:======================================");
        while(t2 != null){
            Integer nv = t2.next == null ? null : t2.next.val;
            Integer rv = t2.random == null ? null : t2.random.val;
            System.out.print("val:"+t2.val+" next:"+nv+" random:"+rv);
            t2 = t2.next;
            System.out.println();
        }
        System.out.println("copy:======================================");
    }

    private static NodeRandom deepCopyLL(NodeRandom n1){
        NodeRandom c1 = n1;
        NodeRandom newHead = new NodeRandom(-1);
        while(c1!=null){
            NodeRandom co1 = new NodeRandom(c1.val);
            if(newHead.next == null) newHead.next = co1;
            co1.next = c1.next;
            c1.next = co1;
            c1 = c1.next.next;
        }

        c1 = n1;
        while(c1!=null){
            NodeRandom co1 = c1.next;
            if(c1.random == null) co1.random = null;
            else if(c1.random == c1) co1.random = co1;
            else co1.random = c1.random.next;
            c1 = c1.next.next;
        }
        c1=n1;
        while (c1!=null){
            NodeRandom co1 = c1.next;
            c1.next = co1.next;
            co1.next = co1.next == null ? null : co1.next.next;
            c1 = c1.next;
        }

        return newHead.next;
    }

    private static NodeRandom getLL(){
        NodeRandom nodeRandom5 = new NodeRandom(5);
        NodeRandom nodeRandom4 = new NodeRandom(4, nodeRandom5);
        NodeRandom nodeRandom3 = new NodeRandom(3, nodeRandom4);
        NodeRandom nodeRandom2 = new NodeRandom(2, nodeRandom3);
        NodeRandom nodeRandom1 = new NodeRandom(1, nodeRandom2);
        NodeRandom nodeRandom0 = new NodeRandom(0, nodeRandom1);

        nodeRandom0.random = nodeRandom5;
        nodeRandom1.random = null;
        nodeRandom2.random = nodeRandom0;
        nodeRandom3.random = nodeRandom2;
        nodeRandom4.random = nodeRandom4;
        nodeRandom5.random = nodeRandom1;

        return nodeRandom0;
    }
}


class NodeRandom {
    int val;
    NodeRandom next;
    NodeRandom random;

    NodeRandom(int val, NodeRandom next, NodeRandom random){
        this.val = val;
        this.next = next;
        this.random = random;
    }

    NodeRandom(int val, NodeRandom next){
        this(val, next, null);
    }
    NodeRandom(int val){
        this(val, null, null);
    }
}
