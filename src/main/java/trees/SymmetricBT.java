package trees;

public class SymmetricBT {
    public static void main(String[] args) {
        Node node = getTree1();
        boolean isSymmetric = isTreeSymmetric(node.left, node.right);
        System.out.println(isSymmetric);
    }

    private static boolean isTreeSymmetric(Node node1, Node node2) {
        if(node1 == null || node2 == null){
            return node1 == node2;
        }
        if(node1.val != node2.val){
            return false;
        }
        return isTreeSymmetric(node1.left, node2.right)
                &&
                isTreeSymmetric(node1.right, node2.left) ;
    }

    private static Node getTree(){
        Node mid5 = new Node(5);
        Node mid6 = new Node(6);
        Node mid7 = new Node(3, mid5, mid6);
        Node mid8 = new Node(3,mid6, mid5);
        Node mid3 = new Node(3, mid5, mid6);
        Node mid4 = new Node(3,mid6, mid5);
        Node mid1 = new Node(2, mid3, mid4);

        Node mid2 = new Node(2, mid7, mid8);
        Node root = new Node(1, mid1, mid2);

        return root;
    }

    private static Node getTree1(){
        Node mid1 = new Node(3);

        Node mid2 = new Node(2);
        Node mid3 = new Node(2);
        Node root = new Node(1, mid2, mid3);
        mid2.right = mid1;
        mid3.right = mid1;
        return root;
    }
}
