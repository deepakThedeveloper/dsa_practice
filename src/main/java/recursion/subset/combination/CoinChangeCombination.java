package recursion.subset.combination;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,5};
        int target = 7;

        int combinations = countInfiniteCoinLoopApproach(denom,  target, 0, "");
        System.out.println("combinations:"+combinations);

        int combinations1 = countInfiniteCoinTakeNotTakeApproach(0,  target, denom, "");
        System.out.println("combinations approach 2:"+combinations1);

        int finiteCoinApproach2 = countFiniteCoinTakeNotTakeApproach(0,  target, denom, "");
        System.out.println("finite combinations approach 2:"+finiteCoinApproach2);
    }

    private static int countInfiniteCoinLoopApproach(int[] denom, int k, int j, String op){
        if(k==0) {
            System.out.println(op);
            return 1;
        }
        if(k<0) return 0;

        int count = 0;
        for(int i=j; i<denom.length; i++){
            count += countInfiniteCoinLoopApproach(denom, k-denom[i], i, op+denom[i]);
        }
        return count;
    }

    private static int countFiniteCoinTakeNotTakeApproach(int idx, int k, int[] den, String op){
        if(k == 0){
            System.out.println(op);
            return 1;
        }
        if(k < 0 || idx == den.length) return 0;

        int take = countFiniteCoinTakeNotTakeApproach(idx + 1, k-den[idx], den, op+den[idx]);
        int notTake = countFiniteCoinTakeNotTakeApproach(idx + 1, k, den, op);

        return take+notTake;
    }

    private static int countInfiniteCoinTakeNotTakeApproach(int idx, int k, int[] den, String op){
        if(k == 0){
            System.out.println(op);
            return 1;
        }
        if(k < 0 || idx == den.length) return 0;

        int take = countInfiniteCoinTakeNotTakeApproach(idx, k-den[idx], den, op+den[idx]);
        int notTake = countInfiniteCoinTakeNotTakeApproach(idx+1, k, den, op);

        return take+notTake;
    }

    //    private static int totalCoinCombinationWaysApproach2(int n, int k, int[] den, String op){
////        if(k==0) return 1;
//        if(n==0){
//            if(k==0 || k>=den[0] && k % den[0] == 0){
//                System.out.println(op);
//                return 1;
//            }
//            return 0;
//        }
//        int notTake = totalCoinCombinationWaysApproach2(n-1, k, den, op);
//        int take = 0;
//        if(k>=den[n]){
//            take = totalCoinCombinationWaysApproach2(n, k-den[n], den, op+den[n]);
//        }
//        return take+notTake;
//    }
}
