package java8.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapFeatures {
    public static void main(String[] args) {
        String text = "aabbcddddeefA";

        Map<Character, String> map = new HashMap<>();
        for(Character c : text.toCharArray()){
            map.put(c, map.getOrDefault(c,"")+c);
        }

        Comparator<String> stringComparator = Comparator.comparing(String::length, Comparator.reverseOrder());
        String sortedString = map.values().stream()
                .sorted(stringComparator)
                .collect(Collectors.joining());

    }
}
