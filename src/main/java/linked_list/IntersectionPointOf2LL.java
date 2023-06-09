package linked_list;

import java.util.Arrays;
import java.util.List;

public class IntersectionPointOf2LL {
    public static void main(String[] args) {
        List<Node1> node1s = nodeList();
        int intersection = findIntersectionPointApproach1(node1s.get(0), node1s.get(1));
        System.out.println(intersection);

        int intersection1 = findIntersectionPointApproach2(node1s.get(0), node1s.get(1));
        System.out.println(intersection1);
    }

    private static int findIntersectionPointApproach1(Node1 n1, Node1 n2){
        int n = findLength(n1);
        int m = findLength(n2);

        Node1 c1 = n1, c2 = n2;
        while(n>m){
            n--;
            c1=c1.next;
        }
        while (m>n){
            m--;
            c2=c2.next;
        }
        while(c1!=null && c2!=null){
            if(c1 == c2) return c1.val;
            c1 = c1.next;
            c2 = c2.next;
        }
        return -1;
    }

    private static int findIntersectionPointApproach2(Node1 n1, Node1 n2){
        Node1 c1 = n1, c2 = n2;
        while(c1 != c2){
            c1 = c1 == null ? n2 : c1.next;
            c2 = c2 == null ? n1 : c2.next;
        }
        return c1 == null ? -1 : c1.val;
    }

    private static int findLength(Node1 n1){
        Node1 c2 = n1;
        int m = 0;
        //length of second linked list
        while(c2!=null) {
            m++;
            c2 = c2.next;
        }
        return m;
    }

    private static List<Node1> nodeList(){
        Node1 nnode6 = new Node1(6);
        Node1 nnode5 = new Node1(5, nnode6);
        Node1 nnode4 = new Node1(4, nnode5);
        Node1 nnode3 = new Node1(3, nnode4);
        Node1 nnode2 = new Node1(2, nnode3);
        Node1 nnode1 = new Node1(1, nnode2);
        Node1 nnode0 = new Node1(0, nnode1);

        Node1 mnode3 = new Node1(31, nnode4);
        Node1 mnode2 = new Node1(21, mnode3);
        Node1 mnode1 = new Node1(11, mnode2);
        Node1 mnode0 = new Node1(01, mnode1);

        return Arrays.asList(nnode0, mnode0);
    }
}
