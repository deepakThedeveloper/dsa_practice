package recursion;

//https://leetcode.com/problems/k-th-symbol-in-grammar/description/
public class KthSymbolInGrammar {

    public static void main(String[] args){
        int n = 3, k = 3;
        int val = kthGrammar(n, k);
        System.out.println("val:"+val);
    }

    // refer: kth_symbol_in_grammar.jpg    for intution
    public static int kthGrammar(int n, int k) {
        if(n==1) return 0;

        int parent;
        if(k % 2 == 0){
            return kthGrammar(n-1, k/2) == 0 ? 1 : 0;
        }
        else{
            return kthGrammar(n-1, (k+1)/2) == 0 ? 0 : 1;
        }
    }
}
