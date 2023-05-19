package algorithm;

//String s2 present in String s1 matching algorithm.
// In general algo we compare char of s2 with char of s1 and as they are matching we move both s1 and s2 pointer.
// as soon as we find any character not mathc then we move s2 pointer to start and s1 pointer to point where we started our match
// this takes O(mn) time complexity. so to avoid this we use KMP pattern which gives us O(m+n) time complexity
public class KMPAlgorithm {
    public static void main(String[] args) {
        char[] a = {'a','b','a','b','c','a','b','c','a','b','a','b','a','b','d'};
        char[] b = {'a','b','a','b','d'};

    }
}
