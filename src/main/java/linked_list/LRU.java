package linked_list;

import lombok.AllArgsConstructor;

import java.util.HashMap;

//10,09,08,07,06,05,04,03,02,01
//1 ,02,04,08,16,32,64,128,256,512
public class LRU {
    private static final HashMap<Integer, Entry> map = new HashMap<>();
    private static int size = 0;
    private static int threshold = 3;
    private static Entry head = null, tail = null;

    public static void main(String[] args) {
        System.out.println(get(2));
        put(1,13);
        put(2,14);
        System.out.println(get(1));
        System.out.println(get(2));
        put(3,15);
        put(4,20);
        System.out.println(get(3));
        System.out.println(get(1));
        System.out.println(get(4));
    }

    public static int get(int key){
        if(!map.containsKey(key)) return -1;
        Entry entry = map.get(key);
        if(entry.prev != null) entry.prev.next = entry.next;
        if(entry.next != null) entry.next.prev = entry.prev;

        if(entry == tail){
            tail = entry.prev;
        }
        head.prev = entry;
        entry.next = head;
        head = entry;
        return entry.value;
    }

    public static void put(int key, int value) {
        Entry entry = new Entry(key, value, null, null);
        if (head == null) head = entry;
        if (tail == null) tail = entry;
        else {
            if (size >= threshold) {
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                size--;
            }
            head.prev = entry;
            entry.next = head;
            head = entry;
        }
        map.put(key, entry);
        size++;
    }


    @AllArgsConstructor
    static class Entry{
        int key;
        int value;
        Entry next;
        Entry prev;
    }
}
