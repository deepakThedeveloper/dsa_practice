package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetStairsPath {
    public static void main(String[] args) {
        int n = 4;
        List<String> paths = getPaths(n);
        paths.forEach(System.out::println);
        /*int s = findStep(n);
        System.out.println(s);*/
    }

    private static List<String> getPaths(int n) {
        if(n ==  0){
            List<String> paths = new ArrayList<>();
            paths.add("");
            return paths;
        }

        if(n<0){
            return new ArrayList<>();
        }
        List<String> paths1 = getPaths(n-1);
        List<String> paths2 = getPaths(n-2);
        List<String> paths3 = getPaths(n-3);

        List<String> paths = new ArrayList<>();
        for(String p : paths1){
            paths.add("1"+p);
        }
        for(String p : paths2){
            paths.add("2"+p);
        }
        for(String p : paths3){
            paths.add("3"+p);
        }

        return paths;
    }

    public static int findStep(int n)
    {
        System.out.print(n+" ");
        if ( n == 0)
            return 1;
        else if (n < 0)
            return 0;

        else {
            int step1 = findStep(n - 3);

            int step2 = findStep(n - 2);

            int steps3 = findStep(n - 1);

            return step1+step2+steps3;
        }
    }
}
/*
n=6  [1,2]
111111
11112
11211
21111
1122
2112
2211
222
---

33
1113
3111


 */
