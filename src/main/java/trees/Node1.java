package trees;

import java.util.Collections;
import java.util.List;

public class Node1 {
    int value;
    List<Node1> children;

    public Node1(int value){
        this(value, Collections.emptyList());
    }
    public Node1(int value, List<Node1> children){
        this.value = value;
        this.children = children;
    }
}
