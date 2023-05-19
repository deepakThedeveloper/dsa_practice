package recursion;

import java.util.ArrayList;
import java.util.List;

// given 2 variables n and k. n = 3 means (1,2,3) and its all permutation which is n!.
// given k is to find kth permutation. e.g.: if n=3 has 6 permutation and k=5 then return 5th permutation
public class KthPermutation {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;

        List<Integer> kthPermutation = findPermutation(n, k);
        System.out.println(kthPermutation);
    }

    private static List<Integer> findPermutation(int n, int k){
        int eachValuePCount = Factorial.findFactorial(n)/n;
        int count ;
        int num = -1;
        for(int i=1; i<=n; i++){
            count = i * eachValuePCount;
            if(k<=count) {
                num = i;
                break;
            }
        }
        if(num == -1) return null;
        List<List<Integer>> numPermutations = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        findNumPermutation(n, num, new ArrayList<>(), numPermutations, visited);
        //System.out.println(numPermutations);
        int v = k%eachValuePCount;
        return numPermutations.get(v-1);
    }

    private static void findNumPermutation(int n, int num, List<Integer> perm, List<List<Integer>> finalList,
                                           boolean[] visited){
        if(perm.size() == n){
            finalList.add(new ArrayList<>(perm));
            return;
        }

        for(int i=1; i<=n; i++){
            if(perm.isEmpty() && i!=num) continue;
            if(visited[i]) continue;
            visited[i] = true;
            perm.add(i);
            findNumPermutation(n, num, perm, finalList, visited);
            perm.remove(perm.size()-1);
            visited[i] = false;
        }
    }
}
