package trees;


import lombok.AllArgsConstructor;

public class IsItBST {
    public static void main(String[] args) {
        Node invalidNode = getInvalidNode();
        Data12 Data12 = isItBST(invalidNode);
        System.out.println("min:"+Data12.min+" max:"+Data12.max+" valid:"+Data12.valid);

        Node validNode = getValidNode();
        Data12 data1 = isItBST(validNode);
        System.out.println("min:"+data1.min+" max:"+data1.max+" valid:"+data1.valid);
    }

    private static Node getInvalidNode() {
        Node node10 = new Node(77);
        Node node9 = new Node(60);
        Node node8 = new Node(40);
        Node node7 = new Node(30);
        Node node6 = new Node(87);
        Node node5 = new Node(62, node9, node10);
        Node node4 = new Node(37,node7, node8);
        Node node3 = new Node(12);
        Node node2 = new Node(75, node5, node6);
        Node node1 = new Node(25, node3, node4);
        Node root = new Node(50, node1, node2);

        return root;
    }
    private static Node getValidNode() {
        Node node7 = new Node(54);
        Node node6 = new Node(2);
        Node node5 = new Node(1, null, node6);
        Node node4 = new Node(15);
        Node node3 = new Node(3, node5, null);
        Node node2 = new Node(80, node7, null);
        Node node1 = new Node(10, node3, node4);
        Node root = new Node(50, node1, node2);

        return root;
    }

    private static Data12 isItBST(Node root) {
        if(root == null){
            return new Data12(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        Data12 lData = isItBST(root.left);
        if(!lData.valid){
            return lData;
        }
        Data12 rData = isItBST(root.right);
        if(!rData.valid){
            return rData;
        }

        int min = Math.min(root.val, Math.min(lData.min, rData.min));
        int max = Math.max(root.val, Math.max(lData.max, rData.max));
        if(root.val > lData.max && root.val <= rData.min){
            return new Data12(min, max, true);
        }
        else {
            return new Data12(min, max, false);
        }
    }
}

@AllArgsConstructor
class Data12{
    int min;
    int max;
    boolean valid;
}
