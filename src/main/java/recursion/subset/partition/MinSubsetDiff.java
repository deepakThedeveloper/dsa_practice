package recursion.subset.partition;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetDiff {
    public static void main(String[] args) {
        int[] arr = {4,3,2,6,5};

//        List<Integer> set1 = new ArrayList<>();
//        List<Integer> set2 = new ArrayList<>();
//        getMinSubsetDiff(arr, 0, 0, 0, set1, set2);
//        System.out.println(minDiff);
//
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<2; i++){ // 2 because we need to divide the array into 2 equal subsets
            list.add(new ArrayList<>());
        }
        diff = arr.length % 2 == 0 ? 0 : 1;
        twoSubsetWithMinSumDiff(arr, list, new int[2], new int[2], 0, 0);
        System.out.println(min);
        System.out.println(finalSubset);

    }
    static int diff = 0;
    static int min = Integer.MAX_VALUE;
    static List<List<Integer>> finalSubset;
    //todo: everything is working only susbet with min diff is not getting printed although min diff is getting calculate
    private static void twoSubsetWithMinSumDiff(int[] arr, List<List<Integer>> subsets, int[] subsetSum,
                                                int[] count, int filledSubset, int idx){

        if(idx == arr.length){
            if(filledSubset == 2 && Math.abs(count[0] - count[1]) == diff){
                int sumDiff = Math.abs(subsetSum[0] - subsetSum[1]);
                if(min > sumDiff){
                    min = sumDiff;
                    finalSubset = new ArrayList<>(subsets); // subset printing is not working
                   // finalSubset.add(subsets.get(subsets.size()-1));
                }
                else{
                    finalSubset.addAll(subsets);
                }
            }
            return;
        }
        for(int i=0; i<subsets.size(); i++){
            List<Integer> temp = subsets.get(i);
            if(temp.size()>0){
                temp.add(arr[idx]);
                subsetSum[i] += arr[idx];
                count[i] ++;
                twoSubsetWithMinSumDiff(arr, subsets, subsetSum,  count, filledSubset, idx+1);
                temp.remove(temp.size()-1);
                subsetSum[i] -= arr[idx];
                count[i] --;
            }
            else{
                temp.add(arr[idx]);
                subsetSum[i] += arr[idx];
                count[i] ++;
                twoSubsetWithMinSumDiff(arr, subsets, subsetSum,  count, filledSubset+1, idx+1);
                temp.remove(temp.size()-1);
                subsetSum[i] -= arr[idx];
                count[i] --;
                break;
            }
        }
    }
    static int minDiff = Integer.MAX_VALUE;
    private static void getMinSubsetDiff(int[] a, int sum1, int sum2, int i,
                                         List<Integer> set1,  List<Integer> set2){

        if(i==a.length){
            int diff = Math.abs(sum1 - sum2);
            System.out.print(set1+" ");
            System.out.print(set2+" ");
            System.out.print(diff+" ");
            System.out.println();
            if(diff<minDiff){
                minDiff = diff;

            }
            return;
        }

        if(set1.size() < (a.length+1)/2) {
            set1.add(a[i]);
            getMinSubsetDiff(a, sum1 + a[i], sum2, i + 1, set1, set2);
            set1.remove(set1.size() - 1);
        }
        if(set2.size() < (a.length+1)/2) {
            set2.add(a[i]);
            getMinSubsetDiff(a, sum1, sum2 + a[i], i + 1, set1, set2);
            set2.remove(set2.size() - 1);
        }
    }
}
