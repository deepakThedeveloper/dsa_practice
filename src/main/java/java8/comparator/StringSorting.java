package java8.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringSorting {
    public static void main(String[] args) {
        //String[] arr = {"bb","a", "c", "dd"};
        String[] arr = {"3", "30", "34", "5", "9"};
        //String[] arr = {"54", "546", "548", "60"};
        Arrays.sort(arr, Comparator.reverseOrder());

        Arrays.stream(arr).forEach(v -> System.out.print(v+", "));
        System.out.println();
        String temp = "";
        for(int i=0; i<arr.length-1; i=i+2){
            String t1 = arr[i]+arr[i+1];
            String t2 = arr[i+1]+arr[i];
            temp = temp+ (t1.compareTo(t2) > 1 ? t1 : t2);
        }
        System.out.println(temp);
        /*Optional<String> joined = Arrays.stream(arr).reduce((o1, o2)-> {
            System.out.println(o1+"--"+o2);
            return o1+o2;
        });
        System.out.println(joined.get());*/
    }
}
//3001, 30
//300130 - 303001
//30,30
//30,300
//30300 - 30030
//31,3
//331 - 313
//32,31
//3231 - 3132
//399 , 30
//39930 - 30399