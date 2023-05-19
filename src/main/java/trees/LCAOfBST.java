package trees;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//LCA - Lowest common ancestor
public class LCAOfBST {
    public static void main(String[] args) {
        Node node10 = new Node(70);
        Node node9 = new Node(60);
        Node node8 = new Node(40);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node9, node10);
        Node node4 = new Node(37, node7, node8);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(20, node3, node4);
        Node root = new Node(50, node1, node2);

        Node node = findLowestCommonAncestorInBinaryTree(root, 12, 40);
        System.out.println(lca);
        System.out.println(node.val);
    }

    static int lca = Integer.MIN_VALUE;
    private static Node findLowestCommonAncestorInBinaryTree(Node root, int k1, int k2) {
        if(root == null){
            return null;
        }

        Node l = findLowestCommonAncestorInBinaryTree(root.left, k1, k2);
        Node r = findLowestCommonAncestorInBinaryTree(root.right, k1, k2);

        if(l != null && r!=null){
            lca = root.val;
            return null;
        }

        if(root.val == k1 || root.val == k2){
            return root;
        }
        else{
            if(l==null && r==null)
                return null;
            else if(l!=null)
                return l;
            else return r;
        }

    }
}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Ancestor{
    Integer v1, v2, a1;
}
