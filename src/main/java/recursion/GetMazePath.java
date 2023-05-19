package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePath {
    public static void main(String[] args) {
//        List<String> path =  getMazePath(0,0,3,3);
//        System.out.println(path);
//        System.out.println(path.size());
//
//        System.out.println();
//        int totalPath = getMazePathRevision(0,0,3,3,"");
//        System.out.println();
//        System.out.println("totalPaths:"+totalPath);

        int totalPaths = getMazePathWithJumpsRevision1(0, 0, 3, 3, 3, "");
        System.out.println();
        System.out.println("total paths:"+totalPaths);

        int totalPaths1 = getMazePathWithJumpsRevision2(0, 0, 3, 3, 3, "");
        System.out.println();
        System.out.println("total paths:"+totalPaths1);

        int totalPaths2 = getMazePathWithJumpsRevision3(0, 0, 3, 3, 3, "");
        System.out.println();
        System.out.println("total paths:"+totalPaths1);

        List<String> totalPaths4 = getMazePathWithJumpsRevision4(0, 0, 3, 3, 3, "");
        System.out.println();
        System.out.println("total paths:"+totalPaths4.size());
    }

    private static int getMazePathWithJumpsRevision1(int sr, int sc, int dr, int dc, int jumps, String path){
        if(sr == dr && sc == dc){
            //System.out.print(path+", ");
            return 1;
        }
        if(sr>dr || sc>dc || sr<0 || sc<0 || jumps<=0) return 0;

        int sum = 0;
        for(int i=1; i<jumps; i++) {
            sum += getMazePathWithJumpsRevision1(sr, sc + i, dr, dc, jumps, path + "R" + i);
        }
        for(int i=1; i<jumps; i++) {
            sum += getMazePathWithJumpsRevision1(sr+i, sc, dr, dc, jumps, path + "D" + i);
        }
        for(int i=1; i<jumps; i++) {
            sum += getMazePathWithJumpsRevision1(sr+i, sc + i, dr, dc, jumps, path + "Di" + i);
        }
        return sum;
    }

    private static List<String> getMazePathWithJumpsRevision4(int sr, int sc, int dr, int dc, int jumps, String path){
        if(sr == dr && sc == dc){
            List<String> list = new ArrayList<>();
            list.add("");
            //System.out.print(path+", ");
            return list;
        }
        if(sr>dr || sc>dc || sr<0 || sc<0 || jumps<=0) return new ArrayList<>();

        List<String> list = new ArrayList<>();
        for(int i=1; i<jumps; i++) {
            List<String> l1 = getMazePathWithJumpsRevision4(sr, sc + i, dr, dc, jumps, path + "R" + i);
            for(String p : l1){
                list.add("R"+i+p);
            }
        }
        for(int i=1; i<jumps; i++) {
            List<String> l1 = getMazePathWithJumpsRevision4(sr+i, sc, dr, dc, jumps, path + "D" + i);
            for(String p : l1) {
                list.add("D" + i + p);
            }
        }
        for(int i=1; i<jumps; i++) {
            List<String> l1 = getMazePathWithJumpsRevision4(sr+i, sc + i, dr, dc, jumps, path + "Di" + i);
            for(String p : l1) {
                list.add("Di" + i + p);
            }
        }
        return list;
    }

    private static int getMazePathWithJumpsRevision2(int sr, int sc, int dr, int dc, int jumps, String path){
        if(sr == dr && sc == dc){
            //System.out.print(path+", ");
            return 1;
        }
        if(sr>dr || sc>dc || sr<0 || sc<0) return 0;

        int sum = 0;
        for(int i=1; i<jumps; i++) {
            sum += getMazePathWithJumpsRevision2(sr, sc + i, dr, dc, jumps, path + "R" + i);
            sum += getMazePathWithJumpsRevision2(sr + i, sc, dr, dc, jumps, path + "D" + i);
            sum += getMazePathWithJumpsRevision2(sr + i, sc + i, dr, dc, jumps, path + "Di" + i);
        }
        return sum;
    }

    private static int getMazePathWithJumpsRevision3(int sr, int sc, int dr, int dc, int jumps, String path){
        if(sr == dr && sc == dc){
            //System.out.print(path+", ");
            return 1;
        }
        if(sr>dr || sc>dc || sr<0 || sc<0) return 0;

        int sum = 0;
        sum += getMazePathWithJumpsRevision3(sr, sc + 1, dr, dc, jumps, path + "R" + 1);
        sum += getMazePathWithJumpsRevision3(sr, sc + 2, dr, dc, jumps, path + "R" + 2);
        sum += getMazePathWithJumpsRevision3(sr, sc + 3, dr, dc, jumps, path + "R" + 3);
        sum += getMazePathWithJumpsRevision3(sr + 1, sc, dr, dc, jumps, path + "D" + 1);
        sum += getMazePathWithJumpsRevision3(sr + 2, sc, dr, dc, jumps, path + "D" + 2);
        sum += getMazePathWithJumpsRevision3(sr + 3, sc, dr, dc, jumps, path + "D" + 3);
        sum += getMazePathWithJumpsRevision3(sr + 1, sc + 1, dr, dc, jumps, path + "Di" + 1);
        sum += getMazePathWithJumpsRevision3(sr + 2, sc + 2, dr, dc, jumps, path + "Di" + 2);
        sum += getMazePathWithJumpsRevision3(sr + 3, sc + 3, dr, dc, jumps, path + "Di" + 3);
        return sum;
    }

    private static int getMazePathRevision(int sr, int sc, int dr, int dc, String op){
        if(sr == dr && sc == dc){
            System.out.print(op+" ");
            return 1;
        }
        if(sr>dr || sc > dc || sr<0 || sc<0) return 0;

        return getMazePathRevision(sr, sc+1, dr, dc, op+"R")+
        getMazePathRevision(sr+1, sc, dr, dc, op+"D");
    }

    private static List<String> getMazePath(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            List<String> list =  new ArrayList<>();
            list.add("");
            return list;
        }
        List<String> hPaths = new ArrayList<>();
        List<String> vPaths = new ArrayList<>();

        if(sc<dc){
            hPaths  = getMazePath(sr, sc+1, dr, dc);
        }
        if(sr<dr){
            vPaths  = getMazePath(sr+1, sc, dr, dc);
        }
        List<String> paths = new ArrayList<>();
        for(int i=0; i<hPaths.size(); i++){
            paths.add("R"+hPaths.get(i));
        }
        for(int i=0; i<vPaths.size(); i++){
            paths.add("D"+vPaths.get(i));
        }
        return paths;
    }
}
