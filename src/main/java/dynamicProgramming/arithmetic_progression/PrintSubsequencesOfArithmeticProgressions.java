package dynamicProgramming.arithmetic_progression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintSubsequencesOfArithmeticProgressions {
    public static void main(String[] args){
        int[] a = {7,7,7,7,7};
//        int[] a = {2,4,6,8,10};
        printAPSubsequences(a);
    }

    private static void printAPSubsequences(int[] a){
        List<HashMap<Integer, Integer>> progressionList = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            progressionList.add(new HashMap<>());
        }
        int ans = 0;
        for(int i=1; i<a.length; i++){
            for(int j=0; j<i; j++){
                int diff = a[j]-a[i];

                int apsEndingWithJ = progressionList.get(j).getOrDefault(diff, 0);
                int apsEndingWithI = progressionList.get(i).getOrDefault(diff, 0);

                ans += apsEndingWithJ;
                progressionList.get(i).put(diff, apsEndingWithI + apsEndingWithJ + 1);
            }
        }

        System.out.println(ans);
    }
}
