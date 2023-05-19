package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamFeatures {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(2,2);
        map.put(3,1);
        map.put(4,4);

        sortAndCollectKValues(map, 3);
    }

    private static void sortAndCollectKValues(Map<Integer, Integer> map, int k) {
        int[] objects = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k).mapToInt(Map.Entry::getKey).toArray();

        Arrays.stream(objects).forEach(System.out::println);
    }
}
