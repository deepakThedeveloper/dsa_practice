package recursion.subset.partition;

import java.util.ArrayList;
import java.util.List;

// summit malick dsa playlist 2
public class PartitionKSubsets {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(new ArrayList<>());
        }
        //doPartition(1, n, k, 0, list);
        List<List<Integer>> kSubsets = new ArrayList<>();
        for(int i=0; i<k; i++){
            kSubsets.add(new ArrayList<>());
        }
        partitionInKSubsetRevision(n, k, 1, kSubsets, 0);
        System.out.println(kSubsets);
    }

    private static void partitionInKSubsetRevision(int n, int k, int idx, List<List<Integer>> op, int filledSubset){
        if(idx > n){
            if(filledSubset == k){
                System.out.println(op);
            }
            return;
        }
        for(int i=0; i<op.size(); i++){
            List<Integer> list = op.get(i);
            if(list.size() > 0){
                list.add(idx);
                partitionInKSubsetRevision(n, k, idx+1, op, filledSubset);
                list.remove(list.size()-1);
            }
            else{
                list.add(idx);
                partitionInKSubsetRevision(n, k, idx+1, op, filledSubset+1);
                list.remove(list.size()-1);
                break;
            }
        }
    }

    private static void doPartition(int j, int n, int k, int nos, List<List<Integer>> list) {
        if(j>n){
            if(nos == k){
                System.out.println(list);
            }
            return;
        }

        for(int i=0; i<list.size(); i++){
            if(list.get(i).size()>0){
                list.get(i).add(j);
                doPartition(j+1, n, k, nos, list);
                list.get(i).remove(list.get(i).size()-1);
            }
            else{
                list.get(i).add(j);
                doPartition(j+1,n, k, nos+1, list);
                list.get(i).remove(list.get(i).size()-1);
                break;
            }
        }
    }
}
