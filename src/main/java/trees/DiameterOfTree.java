package trees;

import java.util.Arrays;

class Data11 {
    int deepest = 0;
    int longest = 0;
}
//diameter - maximum edges between any two nodes is diameter
public class DiameterOfTree {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        Data11 diameter = findDiameter(root);
        System.out.println(diameter.longest);
        System.out.println("----:"+longest);
    }

    // expectations: to visit all nodes and return the max number of edges between any two node
    // faith: 20,30,40 returns max(total edges)
    // ef: at 10 I need to find two max values of 20, 30, 40 and add 2 in it and return

    static int longest = 0;
    private static Data11 findDiameter(Node1 root) {
        int max1 = -1;
        int max2 = -1;

        for(Node1 child : root.children){
            Data11 d1 = findDiameter(child);
            if(max1 == -1){
                max1 = d1.deepest;
            }
            else if(max2 == -1){
                max2 = d1.deepest;
            }
            else if(d1.deepest > max1 || d1.deepest > max2) {
                max2 = Math.max(max1, max2);
                max1 = d1.deepest;
            }
        }
        Data11 d1 = new Data11();
        d1.deepest = Math.max(max1, max2) + 1;
        d1.longest = max1 + max2 + 2;
        if(longest < d1.longest){
            longest = d1.longest;
        }
        return d1;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(160);
        Node1 c221 = new Node1(150);
        Node1 c22 = new Node1(140,Arrays.asList(c221,c222));
        Node1 c21 = new Node1(130);
        Node1 c1211111 = new Node1(170);
        Node1 c121111 = new Node1(170, Arrays.asList(c1211111));
        Node1 c1221111 = new Node1(180);
        Node1 c122111 = new Node1(180, Arrays.asList(c1221111));
        Node1 c12111 = new Node1(110, Arrays.asList(c121111));
        Node1 c12211 = new Node1(120, Arrays.asList(c122111));
        Node1 c1211 = new Node1(90, Arrays.asList(c12111));
        Node1 c1221 = new Node1(100, Arrays.asList(c12211));
        Node1 c121 = new Node1(70, Arrays.asList(c1211));
        Node1 c122 = new Node1(80, Arrays.asList(c1221));
        Node1 c12 = new Node1(60, Arrays.asList(c122));
        Node1 c11 = new Node1(50, Arrays.asList(c121));

        Node1 c31 = new Node1(100);
        Node1 c3 = new Node1(40, Arrays.asList(c31));
        Node1 c2 = new Node1(30, Arrays.asList(c21,c22));
        Node1 c1 = new Node1(20,Arrays.asList(c11,c12));
        Node1 root = new Node1(10, Arrays.asList(c1,c2,c3));

        return root;
    }
}
