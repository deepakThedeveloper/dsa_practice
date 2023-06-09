package graphs.disjointset;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            rank.add(0);
            size.add(1);
            parent.add(i);
        }
    }

    public int findUParent(int node){
        if(node == parent.get(node)) return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v) return; // both belongs to same component so no further ops
        if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }
        else if(rank.get(ulp_v) > rank.get(ulp_u)){
            parent.set(ulp_u, ulp_v);
        }
        else {
            parent.set(ulp_v, ulp_u);
            int cRank = rank.get(ulp_u)+1;
            rank.set(ulp_u, cRank);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if(ulp_u == ulp_v) return; // both belongs to same component so no further ops
        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
            int cSize = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_u, cSize);
        }
        else {
            parent.set(ulp_u, ulp_v);
            int cSize = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_v, cSize);
        }
    }

    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(7);
       // byRankTesting(disjointSet);
        bySizeTesting(disjointSet);
    }

    private static void byRankTesting(DisjointSet disjointSet) {

        disjointSet.unionByRank(1, 2);
        disjointSet.unionByRank(2, 3);
        disjointSet.unionByRank(4, 5);
        disjointSet.unionByRank(6, 7);
        disjointSet.unionByRank(5, 6);

        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("3 and 7 belong to same component");
        }
        else
            System.out.println("3 and 7 doesn't belong to same component");

        disjointSet.unionByRank(3, 7);
        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("3 and 7 belong to same component");
        }
        else
            System.out.println("3 and 7 doesn't belong to same component");
    }

    private static void bySizeTesting(DisjointSet disjointSet) {

        disjointSet.unionBySize(1, 2);
        disjointSet.unionBySize(2, 3);
        disjointSet.unionBySize(4, 5);
        disjointSet.unionBySize(6, 7);
        disjointSet.unionBySize(5, 6);

        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("3 and 7 belong to same component");
        }
        else
            System.out.println("3 and 7 doesn't belong to same component");

        disjointSet.unionBySize(3, 7);
        if(disjointSet.findUParent(3) == disjointSet.findUParent(7)){
            System.out.println("3 and 7 belong to same component");
        }
        else
            System.out.println("3 and 7 doesn't belong to same component");
    }
}
