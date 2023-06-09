package graphs.directed;

import javafx.util.Pair;

import java.util.*;

//1-2, 2-3, 3-4 : courses are scheduled. before opting for course 2, 1 should be completed, before 3, 2 should be completed and likewise
public class CourseSchedule {
    public static void main(String[] args) {
        Pair<Map<Integer, List<Integer>>, Integer> graphPair = validCourse();
        boolean isPossible = courseSchedulingIsPossible(graphPair.getKey(), graphPair.getValue());
        System.out.println("valid data:"+isPossible);

        Pair<Map<Integer, List<Integer>>, Integer> graphPair1 = invalidCourse();
        boolean isPossible1 = courseSchedulingIsPossible(graphPair1.getKey(), graphPair1.getValue());
        System.out.println("invalid data:"+isPossible1);
    }

    private static boolean courseSchedulingIsPossible(Map<Integer, List<Integer>> course, int vertices){
        boolean[] visited = new boolean[vertices];
        boolean[] pvisited = new boolean[vertices];
        for(int i=0; i<vertices; i++){
            if(!visited[i]) {
                visited[i] = true;
                pvisited[i] = true;
                if (!canSchedule(course, i, visited, pvisited)) return false;
                pvisited[i] = false;
            }
        }
        return true;
    }

    private static boolean canSchedule(Map<Integer, List<Integer>> course, int sr, boolean[] visited, boolean[] pvisited){
        for(Integer v : course.get(sr)){
            if(!visited[v]){
                visited[v] = true;
                pvisited[v] = true;
                if(!canSchedule(course, v, visited, pvisited)) return false;
                pvisited[v] = false;
            }
            else if(pvisited[v]) return false;
        }
        return true;
    }

    private static Pair<Map<Integer, List<Integer>>, Integer> validCourse(){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Collections.emptyList());
        graph.put(1, Arrays.asList(0));
        graph.put(2, Arrays.asList(1));
        graph.put(3, Arrays.asList(2));

        return new Pair(graph, 4);
    }

    private static Pair<Map<Integer, List<Integer>>, Integer> invalidCourse(){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Collections.emptyList());
        graph.put(1, Arrays.asList(2));
        graph.put(4, Arrays.asList(3));
        graph.put(2, Arrays.asList(4));
        graph.put(4, Arrays.asList(1));
        graph.put(3, Collections.emptyList());

        return new Pair(graph, 5);
    }

}
