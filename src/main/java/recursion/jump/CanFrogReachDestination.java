package recursion.jump;

import java.util.*;

public class CanFrogReachDestination {
    public static void main(String[] args){
        int[] a = {0, 1, 3, 5, 6, 8, 12, 17};
        for(int a1 : a) stones.add(a1);
        System.out.println(stones);
        boolean canReach = canReach(1, 1, 17, "");
        System.out.println(canReach);
    }


    //leetcode verified:https://leetcode.com/problems/frog-jump/description/
    private  boolean canReach(int[] stones){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<stones.length; i++){
            map.put(stones[i], new HashSet<>());
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        map.put(0, set);
        for(int i=0; i<stones.length; i++){
            Set<Integer> jumps = map.get(stones[i]);
            for(int jump : jumps){
                int nextStone = jump + stones[i];
                if(nextStone == stones[stones.length-1]) return true;
                if(map.containsKey(nextStone)){
                    Set<Integer> nextJumps = map.get(nextStone);
                    if(jump-1>0)
                        nextJumps.add(jump-1);
                    if(jump>0)
                        nextJumps.add(jump);
                    nextJumps.add(jump+1);
                }
            }
        }
        return false;
    }

    static Set<Integer> stones = new LinkedHashSet<>();
    // works with TLE
    private static boolean canReach(int jumps, int curr, int dest, String op){
        if(jumps <= 0 || !stones.contains(curr) || curr > dest) return false;
        if(curr == dest){
            return true;
        }

        if(canReach(jumps-1, curr+jumps-1, dest, op+"->"+(curr+jumps-1))
                || canReach(jumps, curr+jumps, dest, op+"->"+(curr+jumps))
                || canReach(jumps+1, curr+jumps+1, dest, op+"->"+(curr+jumps-1))){
            return true;
        }
        return false;
    }
}
