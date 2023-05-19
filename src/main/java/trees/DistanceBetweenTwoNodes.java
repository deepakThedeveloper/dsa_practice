package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node1 root = getRootNode();
        List<Integer> distance = findDistance(root, 80, 40);
        System.out.println(distance);
    }

    // expectations: to traverse tree and when both the values are present return count of edges between k1 and k2
    // faith: 20, 30, 40 will either return either empty list, or if LCA is found then 3 values in list, if single value is found
    // then only one element in list
    // ef: if list that I receive is of size three then will return the list as it is. if it is empty or contains single element
    // then will continue with traverse
    //Todo
    private static List<Integer> findDistance(Node1 root, int k1, int k2) {
        List<Integer> distance = new ArrayList<>();
        if(root.value == k1 || root.value == k2){
            distance.add(1);
        }
        for(Node1 child : root.children){
            List<Integer> tempValues = findDistance(child, k1, k2);
            distance.addAll(tempValues);
            if(distance.size() == 3){
                return distance;
            }
            if(distance.size() == 2){
                distance.add(distance.get(0) + distance.get(1));
                return distance;
            }
        }
        return distance;
    }

    private static Node1 getRootNode() {
        Node1 c222 = new Node1(120);
        Node1 c221 = new Node1(110);
        Node1 c31 = new Node1(100);
        Node1 c23 = new Node1(90);
        Node1 c22 = new Node1(80,Arrays.asList(c221,c222));
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
