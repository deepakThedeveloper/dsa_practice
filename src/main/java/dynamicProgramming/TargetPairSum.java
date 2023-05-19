package dynamicProgramming;

public class TargetPairSum {
    public static void main(String[] args) {
        int total  = 143;
        int[] a = {9,-48,100, 43,84,74,86,34,-37,60,-29,44};

        findPairs(total, a, "", 0);
    }

    private static void findPairs(int total, int[] a, String op, int i) {
        if(total<0 || i==a.length){
            return;
        }

        if(total==0){
            System.out.println(op);
            return;
        }
        findPairs(total-a[i], a, op+","+a[i], i+1);
        findPairs(total, a, op, i+1);
    }
}
