package backtracking;

import java.util.*;

public class MaximumScoreWords {
    static int[] weight = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};

        char[] allowedChars = {'a','b','c','d','d','d','g','o','o'};
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : allowedChars){
            charCount.put(c, charCount.getOrDefault(c, 0)+1);
        }
        List<List<String>> subsets = new ArrayList<>();
        int wt = getMaxWt(words, charCount, 0, 0, new ArrayList<>(), subsets);

        System.out.println(subsets);
        System.out.println(wt);
    }

    private static int getMaxWt(String[] words, Map<Character, Integer> charCount, int idx, int sum, List<String> wordSubset,
                                List<List<String>> subsets) {
        if(idx == words.length){
            subsets.add(new ArrayList<>(wordSubset));
            return sum;
        }
        int max = Integer.MIN_VALUE;
        for(int i=idx; i<=words.length; i++){
            if(i == words.length){
                int wt = getMaxWt(words, charCount, i, sum, wordSubset, subsets);
                max = Math.max(wt, max);
            }
            else {
                if (!canAddWord(words[i], charCount)) continue;

                wordSubset.add(words[i]);
                int wt = getMaxWt(words, charCount, i + 1, sum+getSum(words[i], charCount), wordSubset, subsets);
                max = Math.max(wt, max);
                removeWord(words[i], charCount);
                wordSubset.remove(wordSubset.size()-1);
            }
        }
        return max;
    }

    private static void removeWord(String word, Map<Character, Integer> charCount) {
        for(char c: word.toCharArray()){
            int count = charCount.get(c)+1;
            charCount.put(c, count);
        }
    }

    private static boolean canAddWord(String word, Map<Character, Integer> charCount) {
        for (char c : word.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) <= 0) return false;
        }
        return true;
    }
    private static int getSum(String word, Map<Character, Integer> map){
        int sum = 0;
        for(char c: word.toCharArray()){
            int count = map.get(c)-1;
            map.put(c, count);
            int index = c - 96;
            sum += weight[index-1];
        }
        return sum;
    }
}
