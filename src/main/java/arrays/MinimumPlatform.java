package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumPlatform {
    public static void main(String[] args) {
        int[] arr = {1100, 940, 950, 1500, 1800, 900};
        int[] dep = {1130, 1200, 1120,1900, 2000, 910};

       int minPlatform  =  findPlatform(arr,dep, arr.length);
        System.out.println(minPlatform);
    }
    static int findPlatform(int arr[], int dep[], int n)
    {
        List<TrainTime> list = sortBasedOnArr(arr, dep, n);
        int depMax = 0;
        int platform = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getArr() == -1){
                continue;
            }
            platform++;
            depMax = list.get(i).getDep();
            list.get(i).arr = -1;
            list.get(i).dep = -1;
            for(int j=i+1; j<list.size(); j++){
                if(list.get(j).getArr()>depMax){
                    depMax = list.get(j).getDep();
                    list.get(j).arr = -1;
                    list.get(j).dep = -1;
                }
            }
        }
        return platform;
    }

    private static List<TrainTime> sortBasedOnArr(int arr[], int dep[], int n){
        List<TrainTime> trainTimeTable = new ArrayList<>();
        List<TrainTime> trainTimeTable1 = new ArrayList<>(trainTimeTable);
        for(int i=0; i<n; i++){
            trainTimeTable.add(new TrainTime(arr[i], dep[i]));
        }

        trainTimeTable.sort(Comparator.comparing(TrainTime::getArr));
        return trainTimeTable;
    }

    static class TrainTime{
        int arr;
        int dep;

        public TrainTime(int arr, int dep){
            this.arr = arr;
            this.dep = dep;
        }
        public int getArr(){
            return this.arr;
        }
        public int getDep(){
            return this.dep;
        }

        @Override
        public String toString(){
            return "arr:"+this.arr+"dep:"+this.dep;
        }
    }
}
