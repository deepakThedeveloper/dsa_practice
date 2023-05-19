package java8.comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
class Person{
    int id;
    String name;
}
public class MapComparator {
    public static void main(String[] args) {
        sortingOnTraditionalObject();
        sortingByCustomObject();
    }

    private static void sortingOnTraditionalObject(){
        Map<Character, Integer> map = new HashMap<>();
        map.put('b',4);
        map.put('a',2);
        map.put('f',7);
        map.put('e',3);
        map.put('c',6);

        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('b',4);
        map1.put('a',2);
        map1.put('f',7);
        map1.put('e',3);
        map1.put('c',6);

        TreeMap<Character, Integer> map2 = new TreeMap<>();
        map2.put('b',4);
        map2.put('a',2);
        map2.put('f',7);
        map2.put('e',3);
        map2.put('c',6);

        System.out.println("before sorting:"+map);
        sortMapBasedOnKeysAscending(map);
        sortMapBasedOnKeysDescending(map);
        sortMapBasedOnValuesAscending(map);
        sortMapBasedOnValuesDescending(map);

        keyAscendingRevision(map1);
        keyDescendingRevision(map1);
        valueAscendingRevision(map1);
        valueDescendingRevision(map1);

        System.out.println("before treemap custom sorting:"+map2);
        treeMapValueAscendingRevision(map2);
        treeMapValueAscendingRevision1(map2);
        treeMapValueDescendingRevision(map2);
    }

    private static void sortingByCustomObject(){
        Person p = new Person(11,"bb");
        Person p1 = new Person(1,"cc");
        Person p2 = new Person(2,"aa");
        Person p3 = new Person(5,"aq");
        Person p4 = new Person(5,"bc");

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        sortPersonAscending(personList);
        sortPersonDescending(personList);

        Map<Integer, List<Person>> mp = personList.stream().collect(Collectors.groupingBy(Person::getId));
        System.out.println("grouped person:"+mp);

        Map<Person, Integer> map3 = new TreeMap<>(Comparator.comparingInt(Person::getId));
        map3.put(p,2);
        map3.put(p1,12);
        map3.put(p2,23);
        map3.put(p3,21);

        System.out.println("sorted map with custom object:"+map3);

        TreeMap<Integer,Person> map4 = new TreeMap<>();
        map4.put(2,p);
        map4.put(12,p1);
        map4.put(23,p2);
        map4.put(21,p3);

        treeMapValueAscendingRevisionPersonClass(map4);
        System.out.println("sorted map with custom object as value:"+map4);
    }

    private static void sortPersonAscending(List<Person> personList){
        personList.sort(Comparator.comparingInt(Person::getId));
        System.out.println("Ascending sorted person by id:"+personList);

        personList.sort(Comparator.comparing(Person::getName));
        System.out.println("Ascending sorted person bu name:"+personList);
    }

    private static void sortPersonDescending(List<Person> personList){
        personList.sort(Comparator.comparingInt(Person::getId).reversed());
        System.out.println("Descending sorted person:"+personList);
        personList.sort(Comparator.comparing(Person::getName).reversed());
        System.out.println("Descending sorted person:"+personList);
    }

    private static void valueDescendingRevision(Map<Character, Integer> map1) {
        Map<Character, Integer> mp4 = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));
        System.out.println(mp4);
    }
    private static void treeMapValueAscendingRevision1(TreeMap<Character, Integer> map1) {
        Comparator<Character> comparator = Comparator.comparing(map1::get);
        Map<Character, Integer> mp3 = new TreeMap<>(comparator);
        mp3.putAll(map1);

        System.out.println(mp3);
    }

    private static void treeMapValueAscendingRevision(TreeMap<Character, Integer> map1) {
        LinkedHashMap<Character, Integer> mp4 = map1.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));

        System.out.println(mp4);
    }

    private static void treeMapValueAscendingRevisionPersonClass(TreeMap<Integer, Person> map1) {
        Comparator<Person> personComparator = Comparator.comparing(Person::getName);


        LinkedHashMap<Integer, Person> mp4 = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(personComparator))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));

        System.out.println(mp4);
    }

    private static void treeMapValueDescendingRevision(Map<Character, Integer> map1) {
        LinkedHashMap<Character, Integer> mp4 = map1.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));

        System.out.println(mp4);
    }

    private static void valueAscendingRevision(Map<Character, Integer> map1) {
        Map<Character, Integer> mp4 = map1.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));
        System.out.println(mp4);
    }

    private static void keyDescendingRevision(Map<Character, Integer> map) {
        Map<Character, Integer> mp4 = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (m, m1) -> m, LinkedHashMap::new ));
        System.out.println(mp4);
    }

    private static void keyAscendingRevision(Map<Character, Integer> map){
        Map<Character, Integer> mp4 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (m, m1) -> m, LinkedHashMap::new ));
        System.out.println(mp4);
    }

    private static void sortMapBasedOnKeysAscending(Map<Character, Integer> map) {
        Map<Character, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));

        System.out.println("sorting on keys ascending");
        System.out.println("after sorting:"+sortedMap);
    }

    private static void sortMapBasedOnKeysDescending(Map<Character, Integer> map) {
        Map<Character, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));

        System.out.println("sorting on keys descending");
        System.out.println("after sorting:"+sortedMap);
    }

    private static void sortMapBasedOnValuesAscending(Map<Character, Integer> map) {
        Map<Character, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));

        System.out.println("sorting on values ascending");
        System.out.println("after sorting:"+sortedMap);
    }

    private static void sortMapBasedOnValuesDescending(Map<Character, Integer> map) {
        Map<Character, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (val1, val2) -> val1, LinkedHashMap::new));

        System.out.println("sorting on values descending");
        System.out.println("after sorting:"+sortedMap);
    }
}
