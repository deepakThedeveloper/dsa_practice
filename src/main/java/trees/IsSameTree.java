package trees;

public class IsSameTree {
    public static void main(String[] args) {
        Node tree1 = tree1();
        Node tree2 = tree2();

        System.out.println(isSameTree(tree1, tree2));
    }

    private static boolean isSameTree(Node tree1, Node tree2) {
        if(tree1 == null || tree2 == null){
            return tree1 == tree2;
        }

        return (tree1.val == tree2.val) && (isSameTree(tree1.left, tree2.left)) && (isSameTree(tree1.right, tree2.right));
    }

    private static Node tree1(){
        Node root = new Node(1);
        Node mid1 = new Node(2);
        Node mid2 = new Node(3);
        Node mid3 = new Node(4);
        Node mid4 = new Node(5);

        root.left = mid1;
        root.right = mid2;

        mid2.left = mid3;
        mid2.right = mid4;

        return root;
    }


    private static Node tree2(){
        Node root = new Node(1);
        Node mid1 = new Node(2);
        Node mid2 = new Node(3);
        Node mid3 = new Node(4);
        Node mid4 = new Node(5);

        root.left = mid1;
        root.right = mid2;

        mid2.left = mid3;
        mid2.right = mid4;

        return root;
    }
}
