package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// reorder array in such a way that a[2*i+1] = 2*a[2*i]
public class DoublePairArray {
    public static void main(String[] args) {
        int[] a = {-8, -3, 8, 8, 4, -6, -4, 2, 0, 2, 1, 4, 0, 16, 8, 4};
        boolean canReorder = canReorder(a);
        System.out.println(canReorder);
    }

    private static boolean canReorder(int[] a){
        Arrays.sort(a);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int a1 : a){
            freqMap.put(a1, freqMap.getOrDefault(a1, 0)+1);
        }
        for(int i=0; i<a.length; i++){
            if(freqMap.get(a[i]) == 0)continue;
            int v = 2 * a[i];
            if(freqMap.containsKey(v)){
                if(freqMap.get(v) == 0) return false;
                freqMap.put(v, freqMap.get(v)-1);
                freqMap.put(a[i], freqMap.get(a[i])-1);
            }
        }
        Optional<Integer> nonZero = freqMap.values().stream().filter(v1-> v1>0).findFirst();
        return !nonZero.isPresent();
    }
}
