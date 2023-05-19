package trees;

import java.util.Arrays;

// ceil value - smallest among larger values than k
// floor value - larger among smallest value than k
class NumericData{
    int ceil;
    int k;
    int floor;

    public NumericData(int k){
        this.ceil = Integer.MAX_VALUE;
        this.k = k;
        this.floor = Integer.MIN_VALUE;
    }
}

public class CAndF {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        int k = 140;
        //findCeilAndFloor(root, k);
        NumericData data = findCeilAndFloor1(root, k);
        System.out.println(floor+" "+k+" "+ceil);
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    private static void findCeilAndFloor(Node1 root, int k) {
        if(root.value == k){
            ceil = k;
            floor = k;
        }
        else{
            if(root.value > k){
                ceil = Math.min(ceil, root.value);
            }
            else{
                floor = Math.max(floor, root.value);
            }
        }

        for(Node1 child : root.children){
            findCeilAndFloor(child, k);
        }
    }

    // todo
    private static NumericData findCeilAndFloor1(Node1 root, int k) {
        NumericData nd = new NumericData(k);
        if(root.value == k){
            nd.ceil = k;
            nd.floor = k;
        }
        else{
            if(root.value > k){
                nd.ceil = Math.min(nd.ceil, root.value);
            }
            else{
                nd.floor = Math.max(nd.floor, root.value);
            }
        }

        for(Node1 child : root.children){
            NumericData finalValues = findCeilAndFloor1(child, k);
            finalValues.ceil = nd.ceil;
            finalValues.floor = nd.floor;
        }
        return nd;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(120);
        Node1 c221 = new Node1(110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80, Arrays.asList(c221,c222));
        Node1 c21 = new Node1(70);
        Node1 c12 = new Node1(60);
        Node1 c11 = new Node1(50);
        Node1 c3 = new Node1(40, Arrays.asList(c31));
        Node1 c2 = new Node1(30, Arrays.asList(c21,c22,c23));
        Node1 c1 = new Node1(20,Arrays.asList(c11,c12));
        Node1 root = new Node1(10, Arrays.asList(c1,c2,c3));

        return root;
    }
}
