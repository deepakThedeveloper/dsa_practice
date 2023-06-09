package linked_list;

import lombok.ToString;

//@ToString
public class Node1 {
    public Integer val;
    public Node1 next;

    public Node1(Integer val) {
        this(val, null);
    }

    public Node1(Integer val, Node1 next) {
        this.val = val;
        this.next = next;
    }

}
