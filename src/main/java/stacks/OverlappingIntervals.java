package stacks;

import java.util.*;

// merge such intervals whose start time is less than or equal to others end time and finally display schedule in asc sort.
public class OverlappingIntervals {
    public static void main(String[] args) {
        int[][] a={{22,28},{3,8},{15,27},{17,19},{2,3},{35,37},{12,16}};
        int[][] a1={{22,28},{3,8},{15,27},{17,19},{2,3},{35,37},{12,16}};
        //int[][] a1={{22,28},{1,8},{25,27},{14,19},{27,30},{5,12}};

        // new schedule code is correct
        System.out.println("new schedule:-----------------------------------");
        int[][] newSchedule = getScheduleRevision1(a1);
        System.out.println();
        Arrays.stream(newSchedule).forEach(v-> System.out.print("{"+v[0]+","+v[1]+"},"));
    }

    private static int[][] getScheduleRevision1(int[][] a){
        Comparator<int[]> comparator = (o1, o2)->Integer.compare(o1[0], o2[0]);
        Arrays.sort(a, comparator);
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        System.out.println();
        System.out.println("sorting");
        Arrays.stream(a).forEach(v-> System.out.print("{"+v[0]+","+v[1]+"},"));
        System.out.println();
        List<Integer[]> list = new ArrayList<>();
        Integer[] curr1 = {a[0][0], a[0][1]};
        list.add(curr1);

        for(int i=1; i<a.length; i++){
            Integer[] curr = list.get(list.size()-1);
            if(curr[1]<a[i][1]) {
                if(curr[1]>=a[i][0]) curr[1] = a[i][1];
                else{
                    Integer[] curr2 = {a[i][0], a[i][1]};
                    list.add(curr2);
                }
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            Integer[] curr = list.get(i);
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }
        return result;
    }
}
