package recursion;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,4,5}; //223,2221,25,1111111,331,511
        int target = 7;

        int combinations = getCombination(denom,  target, 0, "");
        System.out.println("combinations:"+combinations);
    }

    private static int getCombination(int[] denom, int k, int j, String op){
        System.out.println("in method:"+denom[j]);
        if(k==0) {
            System.out.println(op);
            return 1;
        }
        if(k<0) return 0;

        int count = 0;
        for(int i=j; i<denom.length; i++){
            count += getCombination(denom, k-denom[i], i, op+denom[i]);
        }
        return count;
    }
}
