package priorityQueue;

import java.util.Arrays;

public class MaxHeapUsingTree {
    public static void main(String[] args) {
        Node leaf1 = new Node(9);Node leaf2 = new Node(8);Node leaf3 = new Node(15);Node leaf4 = new Node(17);
        Node leaf5 = new Node(13);Node leaf6 = new Node(1);
        Node parent1 = new Node(4);parent1.left = leaf1; parent1.right = leaf2;
        Node parent2 = new Node(14);parent2.left = leaf3; parent2.right = leaf4;
        Node parent3 = new Node(5);parent3.left = leaf5; parent3.right = leaf6;
        Node parent4 = new Node(3);parent4.left = parent1; parent4.right = parent2;
        Node root = new Node(12);root.left = parent4; root.right = parent3;

        int height = 3;
        for(int i=0; i<height; i++){
            maxHeap(root);
        }
        System.out.println("\npreorder:---------------------------- before removal");
        root.preorderDisplay(root);

        System.out.println();
        remove(15, root);

        System.out.println();
        System.out.println("\npreorder:---------------------------- after removal");
        root.preorderDisplay(root);

        /*peek(root);
        poll(root);*/
    }

    private static void remove(int val, Node root) {
        if(root == null) return;
        Node valueReplaced = findValueInTreeAndReplace(root, val);
        if(valueReplaced !=null){
            System.out.println(" value replaced:" + valueReplaced.val);
            heapifyNodeDownwards(valueReplaced);
        }
    }

    private static void heapifyNodeDownwards(Node root) {
        if(root == null) return;
        if(root.left !=null && root.right!=null){
            Node maxValNode = root.left.val > root.right.val ? root.left : root.right;
            if(maxValNode.val > root.val) {
                swap(root, maxValNode);
                heapifyNodeDownwards(maxValNode);
            }
        }
        else if(root.left !=null && root.val < root.left.val){
            swap(root, root.left);
        }

    }

    private static void swap(Node root, Node maxValNode) {
        int temp = root.val;
        root.val = maxValNode.val;
        maxValNode.val = temp;
    }

    private static Node findValueInTreeAndReplace(Node root, int val) {
        if(root == null) return null;
        if(root.val == val){
            root.val = findLastLeafNode(root);
            return root;
        }
        Node leftNode = findValueInTreeAndReplace(root.left, val);
        if(leftNode !=null ) return leftNode;
        Node rightNode = findValueInTreeAndReplace(root.right, val);
        if(rightNode !=null) return rightNode;
        return null;
    }

    // ToDo: to be implemented
    private static int findLastLeafNode(Node root) {
        return 1;
    }


    private static void peek(Node root) {
        System.out.println("peek:" +root.val);
    }

    private static Node poll(Node root){
        if(root == null){
            return null;
        }
        Node replacable = root;
        if(root.left != null && root.right !=null){
            if(root.left.val > root.right.val){
                replacable = poll(root.left);
                if(replacable != null) {
                    root.val = replacable.val;
                    root.left = null;
                }
            }
            else{
                replacable = poll(root.right);
                if(replacable != null) {
                    root.val = replacable.val;
                    root.right = null;
                }
            }
        }
        return root;
    }

    private static void insert(int val) {
        Node newNode = new Node(val);
    }


    private static Node maxHeap(Node root) {
       if(root == null) return null;
       Node leftNode = maxHeap(root.left);
       Node rightNode = maxHeap(root.right);
       Node replaceable = root;
       if(leftNode != null && rightNode != null){
           replaceable = leftNode.val > rightNode.val ? leftNode : rightNode;
       }

       if(replaceable.val > root.val) {
           int temp = root.val;
           root.val = replaceable.val;
           replaceable.val = temp;
       }
           return root;
    }

    //1,3,5,4,6,13,10,9,8,15,17
    //17,1,13,9,3,5,10,4,8,15,6
    //17,15,13,9,6,5,10,4,8,3,1
    private static void heapify(int[] arr, int parentNodeIndex, int last) {
        boolean isSwapped = false;
        for(int i = parentNodeIndex; i>=0; i--) {
            int valIndex = arr[last] > arr[last - 1] ? last : last - 1;
            if (arr[i] < arr[valIndex]) {
                int temp = arr[i];
                arr[i] = arr[valIndex];
                arr[valIndex] = temp;
                isSwapped = true;
            }
            last=last -2;
        }
        if(isSwapped) {
            Arrays.stream(arr).forEach(value -> System.out.print(value+","));
            System.out.println();
            heapify(arr, parentNodeIndex, arr.length - 1);
        }
    }
}
