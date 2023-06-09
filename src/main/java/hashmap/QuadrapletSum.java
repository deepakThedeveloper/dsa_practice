package hashmap;

import java.util.*;

public class QuadrapletSum {
    public static void main(String[] args) {
        int[] a = {2,8,7,2,3,10,2,4, 3,2,10, 10,4,5,5,7,8,7};
        quadrapletSum(a, 20);
    }

    private static Map<Integer, List<List<Integer>>> sumPair = new HashMap<>();

    //todo: duplicate numbers are getting printed
    private static void quadrapletSum(int[] a, int k){
        Arrays.sort(a);
        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
        System.out.println();
        getAllPairSum(a);
        System.out.println(sumPair);
        for(int i=0; i<a.length-1; i++){
            if(i>0 && a[i] == a[i-1])continue;

            System.out.println("==============================================");
            System.out.println("i:"+i+" a[i]:"+a[i]);
            List<List<Integer>> quadrple = threePairSum(a, k-a[i], i+1, a[i]);
            System.out.println(quadrple);
            System.out.println("==============================================");
        }
    }
    private static List<List<Integer>> threePairSum(int[] a, int k, int start, int quadrpleVal){
        int key;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=start; i<a.length; i++){
            if(i>0 && a[i]==a[i-1]) continue;
            key = k-a[i];
            List<List<Integer>> pairList = sumPair.get(key);
            if(pairList == null)continue;
            for(List<Integer> pair : pairList) {
                List<Integer> quadrapletPair = new ArrayList<>(pair);
                quadrapletPair.add(a[i]);
                quadrapletPair.add(quadrpleVal);
                list.add(quadrapletPair);
            }
        }
        return list;
    }

    private static void getAllPairSum(int[] a){
        int sum = 0;
        for(int i=0; i<a.length-1; i++){
            if(i>0 && a[i]==a[i-1]) continue;
            for(int j=i+1; j<a.length; j++){
                if(a[i] == a[j] || a[j] == a[j-1]) continue;
                sum = a[i]+a[j];
                List<Integer> pair = Arrays.asList(a[i], a[j]);
                if(sumPair.containsKey(sum)){
                    sumPair.get(sum).add(pair);
                }
                else{
                    List<List<Integer>> newList = new ArrayList<>();
                    newList.add(pair);
                    sumPair.put(sum, newList);
                }
            }
        }
    }
}
