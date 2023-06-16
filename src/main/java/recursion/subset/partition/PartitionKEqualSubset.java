package recursion.subset.partition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * partition string in k subset such that sum of all subset should be same
 */
public class PartitionKEqualSubset {
    public static void main(String[] args) {
//        String s = "4323521";
        String s = "132";
        int k = 2;

        List<List<Integer>> subsets = new ArrayList<>();
        for(int i=0; i<k; i++){
            subsets.add(new ArrayList<>());
        }
        partitionInKEqualSubset(s, k, subsets, new int[k], 0, 0);

        boolean isPresent = doPartition(s, k, new String[4], new boolean[s.length()]);
        //System.out.println(isPresent);
    }

    private static void partitionInKEqualSubset(String str, int k, List<List<Integer>> subsets, int[] subsetSum, int idx, int filledSubset){
        if(idx >= str.length()){
            if(filledSubset == k){
                for(int i=0; i<k-1; i++){
                    if(subsetSum[i] != subsetSum[i+1]) return;
                }
                System.out.println(subsets);
            }
            return;
        }
        for(int i=0; i<subsets.size(); i++){
            List<Integer> list = subsets.get(i);
            int v = str.charAt(idx) - '0';
            if(!list.isEmpty()){
                subsetSum[i] += v;
                list.add(v);
                partitionInKEqualSubset(str, k, subsets, subsetSum, idx+1, filledSubset);
                list.remove(list.size()-1);
                subsetSum[i] -= v;
            }
            else{
                subsetSum[i] += v;
                list.add(v);
                partitionInKEqualSubset(str, k, subsets, subsetSum, idx+1, filledSubset+1);
                list.remove(list.size()-1);
                subsetSum[i] -= v;
                break;
            }
        }
    }

    // doesn't work for few cases like str = 123, k=2
    private static boolean doPartition(String s, int k, String[] sets, boolean[] visited) {
        if(s.length()==0){
            boolean isNull = false;
            for(int i=0; i< sets.length; i++){
                if(sets[i]==null){
                    isNull = true;
                    break;
                }
            }
            if(!isNull){
                int esum = 0;
                boolean match = true;
                for(int i=0; i< sets.length; i++){
                    String s1 = sets[i];
                    int sum = 0;
                    for(int i1=0; i1<s1.length(); i1++){
                        sum += s1.charAt(i1) -'0';
                    }
                    if(esum == 0) esum = sum;
                    else if(esum!=sum){
                        match = false;
                        break;
                    }
                }
                if(match) {
                    for(int i=0; i< sets.length; i++) {
                        System.out.print(sets[i] + " ");
                    }
                    System.out.println();
                    return true;
                }
            }
            return false;
        }

        for(int i=0; i<s.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            char c = s.charAt(0);
            String str1 = s.substring(1);

            for(int j=0; j<k; j++){
                if(j>0 && sets[j-1] == null) break;
                String temp = sets[j];
                sets[j] = sets[j]==null?""+c : sets[j]+c;
                boolean isValid = doPartition(str1, k, sets, visited);
                if(isValid) return true;
                sets[j] = temp;
            }
            visited[i] = false;
        }
        return false;
    }
}
