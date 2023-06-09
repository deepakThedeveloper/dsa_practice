package recursion.partition;

import java.util.ArrayList;
import java.util.List;

// summit malick dsa playlist 2
public class PartitionKSubsets {
    public static void main(String[] args) {
        int no = 4;
        int k = 3;

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(new ArrayList<>());
        }
        doPartition(1, no, k, 0, list);
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
