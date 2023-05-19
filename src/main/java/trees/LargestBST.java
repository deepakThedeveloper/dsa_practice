package trees;


import lombok.AllArgsConstructor;

public class LargestBST {
    public static void main(String[] args) {
        Node validNode = getValidNode();
        Data2 data1 = findLargestBST(validNode);
        System.out.println("count:"+data1.nodeCount+" value:"+data1.nodeValue);
    }

    private static Node getValidNode() {
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

    private static Data2 findLargestBST(Node root) {
        if(root == null){
            return new Data2(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0,true);
        }
        Data2 lData = findLargestBST(root.left);
        Data2 rData = findLargestBST(root.right);

        int min = Math.min(root.val, Math.min(lData.min, rData.min));
        int max = Math.max(root.val, Math.max(lData.max, rData.max));
        int nodeCount = (lData.nodeCount + rData.nodeCount) + 1;
        if(!lData.valid && !rData.valid){
            return new Data2(min, max, nodeCount, root.val,false);
        }
        if(!rData.valid){
            return lData;
        }
        if(!lData.valid){
            return rData;
        }
        if(root.val > lData.max && root.val <= rData.min){
            return new Data2(min, max, nodeCount , root.val, true);
        }
        else {
            return new Data2(min, max, nodeCount, root.val, false);
        }
    }
}

@AllArgsConstructor
class Data2{
    int min;
    int max;
    int nodeCount;
    int nodeValue;
    boolean valid;
}
