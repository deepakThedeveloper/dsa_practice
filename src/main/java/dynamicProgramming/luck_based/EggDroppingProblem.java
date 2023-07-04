package dynamicProgramming.luck_based;

public class EggDroppingProblem {
    public static void main(String[] args){
        int eggs = 3, floors = 7;
        int minAttempts = minAttemptsToFindCriticalFloor(eggs, floors);
        System.out.println(minAttempts);
    }

    private static int minAttemptsToFindCriticalFloor(int eggs, int floors){
        if(eggs == 0) return 0;
        if(floors == 0) return 0;

        int minAttempts = Integer.MAX_VALUE;

        for(int i=1; i<=floors; i++){
            int break1 = minAttemptsToFindCriticalFloor(eggs-1, i-1) + 1;
            int nonBreak = minAttemptsToFindCriticalFloor(eggs, floors - i) + 1;

            minAttempts = Math.min(minAttempts, Math.max(break1, nonBreak));
        }

        return minAttempts;
    }
}
