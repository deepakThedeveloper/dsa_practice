package recursion;

import matrix.Util;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int[] a = {2,3,5,7,10};
        int rodLength = 5;

        int idx = rodLength-1;
        int maxPrice = maxPriceOfRodCuttingApproach1(idx, rodLength,  a);
        System.out.println("recursion1:"+maxPrice);

//        int maxPrice1 = maxPriceOfRodCuttingApproach2(rodLength, rodLength, a);
//        System.out.println("recursion2:"+maxPrice1);


    }

    private static int maxPriceOfRodCuttingApproach1(int idx, int remainingRodLength, int[] value){
        if(idx == 0) return remainingRodLength*value[0];
        //if(n<=0) return 0;

        int notCut = maxPriceOfRodCuttingApproach1(idx-1, remainingRodLength, value);
        int cut = Integer.MIN_VALUE;
        int rodLength = idx+1;
        if(rodLength<=remainingRodLength) {
            cut = maxPriceOfRodCuttingApproach1(idx, remainingRodLength - rodLength,  value) + value[idx];
        }
        return Math.max(cut, notCut);
    }

    // this code produces wrong result. Reason is when executing operation of cut, in that case if n<0 then I am
    // returning 0 and to 0 value[idx-1] is getting added. 0+value[idx-1]. I can't return Integer.MIN because no matter
    // what I return value[idx-1] is going to get added.
    // this is also logically wrong because value should get added only when we are cutting rod let say by 1 then rodlength
    // should be >=1. if cutting by 2 i.e. idx=2 then rodlength>=2.
    //NOTE: keep below code for analysis purpose.
    private static int maxPriceOfRodCuttingApproach2(int idx, int n, int[] value){
        if(idx == 0) return n*value[0];
        if(n<=0) return 0;

        int notCut = maxPriceOfRodCuttingApproach2(idx-1, n , value);
        int cut = maxPriceOfRodCuttingApproach2(idx, n - idx, value) + value[idx-1];

        return Math.max(cut, notCut);
    }
}
