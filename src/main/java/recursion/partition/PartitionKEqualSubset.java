package recursion.partition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * partition string in k subset such that sum of all subset should be same
 */
public class PartitionKEqualSubset {
    public static void main(String[] args) {
        String s = "4323521";
        int k = 4;

        boolean isPresent = doPartition(s, k, new String[4], new boolean[s.length()]);
        System.out.println(isPresent);
    }

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
