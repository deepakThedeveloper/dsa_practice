package java8.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapFeatures {
    public static void main(String[] args) {
        sortByKeysInAscending();
        sortByKeysInDescending();
        sortByValuesInAscending();
        sortByValuesInDescending();
    }

    private static void sortByValuesInDescending() {
        TreeMap<Character, Integer> map  = new TreeMap<>(Comparator.reverseOrder());
        map.put('b',4);
        map.put('a',2);
        map.put('f',7);
        map.put('e',3);
        map.put('c',6);

        System.out.println("Inserted elements in treemap sorted by descending order on keys");
        System.out.println(map);
    }

    private static void sortByValuesInAscending() {
        /*Comparator<Character> valueComparator = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return 0;
            }
        }
        TreeMap<Character, Integer> map  = new TreeMap<>(ascComparator);
        map.put('b',4);
        map.put('a',2);
        map.put('f',7);
        map.put('e',3);
        map.put('c',6);

        System.out.println("Inserted elements in treemap sorted by descending order on keys");
        System.out.println(map);*/
    }

    private static void sortByKeysInDescending() {
        TreeMap<Character, Integer> map  = new TreeMap<>(Comparator.reverseOrder());
        map.put('b',4);
        map.put('a',2);
        map.put('f',7);
        map.put('e',3);
        map.put('c',6);

        System.out.println("Inserted elements in treemap sorted by descending order on keys");
        System.out.println(map);
    }

    private static void sortByKeysInAscending() {
        Comparator<Character> ascComparator = Character::compareTo;

        TreeMap<Character, Integer> map  = new TreeMap<>(ascComparator);
        map.put('b',4);
        map.put('a',2);
        map.put('f',7);
        map.put('e',3);
        map.put('c',6);

        System.out.println("Inserted elements in treemap sorted by default ascending order on keys");
        System.out.println(map);
    }

}
