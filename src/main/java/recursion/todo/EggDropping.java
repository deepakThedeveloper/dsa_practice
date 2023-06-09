package recursion.todo;

public class EggDropping {
    public static void main(String[] args) {
        int floors = 7;
        int eggs = 3;

    }

    //todo: not able to come up with base case
    private static int minAttemptsToFindCriticalFloor(int f, int e, int idx){
        //if(){}

        int survive = minAttemptsToFindCriticalFloor(f, e, idx+1);
        int breaks = minAttemptsToFindCriticalFloor(f, e-1, idx-1);

        return Math.max(survive, breaks);
    }
}
