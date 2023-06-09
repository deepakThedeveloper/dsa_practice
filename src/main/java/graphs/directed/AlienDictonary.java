package graphs.directed;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// some words are given. need to find order of letters in their dictonary. in english a,b,c,d... is the order.
// need to find out order of letters in aliend dictonary
public class AlienDictonary {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        int k = 4; // it is given that alien uses first 4 characters from eng dictonary.
        List<Character> letters = findLetterOrder(words, k);
        System.out.println(letters);
    }

    private static List<Character> findLetterOrder(String[] words, int k){
        int n = words.length;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<k; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++){
            Pair<Character, Character> nonEqualChar = compareAndReturnFirstNonEqualChar(words[i], words[i+1]);
            if(nonEqualChar == null) continue;
            int i1 = nonEqualChar.getKey() - 'a';
            int j1 = nonEqualChar.getValue() - 'a';
            graph.get(i1).add(j1);
        }

        return topologicalSort(graph, k);
    }

    private static List<Character> topologicalSort(List<List<Integer>> graph, int k){
        int n = graph.size();
        boolean[] visited = new boolean[n];

        System.out.println(graph);
        Stack<Character> letters = new Stack<>();
        List<Character> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfsTraverse(graph, i, visited, letters);
            }
        }
        while(!letters.isEmpty())
            result.add(letters.pop());
        return result;
    }

    private static void dfsTraverse(List<List<Integer>> graph, int sr, boolean[] visited, Stack<Character> ch){
        visited[sr] = true;
        for(Integer it : graph.get(sr)){
            if(!visited[it]){
                dfsTraverse(graph, it, visited, ch);
            }
        }
        ch.push((char)(sr+97));
    }

    private static Pair<Character, Character> compareAndReturnFirstNonEqualChar(String w1, String w2){
        for(int i=0, j=0; i<w1.length() && j<w2.length(); i++, j++){
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(j);
            if(c1 != c2){
                return new Pair<>(c1, c2);
            }
        }
        return null;
    }
}
