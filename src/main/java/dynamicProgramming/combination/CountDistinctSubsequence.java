package dynamicProgramming.combination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctSubsequence {
    public static void main(String[] args) {
        String str = "abbbbcac";
        int distinctSubsequence = distinctSubsequence(str);
        System.out.println(distinctSubsequence);
    }

    private static int distinctSubsequence(String str){
        int[] dp = new int[str.length()+1];
        dp[0]=1;

        Map<Character, Integer> indexMap = new HashMap<>();
        indexMap.put('.', 0);
        for(int i=0; i<str.length(); i++){
            dp[i+1] = dp[i]*2;
            char c = str.charAt(i);
            if(indexMap.containsKey(c)){
                int prevIndex = indexMap.get(c)-1;
                dp[i+1] = dp[i+1]-dp[prevIndex];
            }
            indexMap.put(c, i+1);
        }
        System.out.println(indexMap);
        Arrays.stream(dp).forEach(v->System.out.print(v+" "));
        System.out.println();
        return dp[str.length()];
    }
}
