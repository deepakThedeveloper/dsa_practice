package recursion.permutation;

import recursion.Factorial;

import java.util.ArrayList;
import java.util.List;

// given 2 variables n and k. n = 3 means (1,2,3) and its all permutation which is n!.
// given k is to find kth permutation. e.g.: if n=3 has 6 permutation and k=5 then return 5th permutation
public class KthPermutation {
    public static void main(String[] args) {
        int n = 4;
        int k = 24;

        String kthPermutation = findPermutation(n, k);
        System.out.println(kthPermutation);
    }

    private static String findPermutation(int n, int k){
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++){
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k=k-1;
        while(true){
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if(numbers.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
