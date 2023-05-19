package recursion;

public class PrintStairsPath {
    public static void main(String[] args) {
        printSteps(4, "");
        System.out.println();
        int totalPaths = stairsPathRevision1(4,"");
        System.out.println();
        System.out.println("total paths:"+totalPaths);
    }

    private static int stairsPathRevision1(int n, String path){
        if(n==0){
            System.out.print(path+", ");
            return 1;
        }
        if(n<0) return 0;

        return stairsPathRevision1(n-1, path+"1") +
        stairsPathRevision1(n-2, path+"2") +
        stairsPathRevision1(n-3, path+"3");
    }
    private static void printSteps(int n, String op) {
        if(n==0){
            System.out.print(op+", ");
            return;
        }
        if(n<0){
            return;
        }
        printSteps(n-1, op+"1");
        printSteps(n-2, op+"2");
        printSteps(n-3, op+"3");
    }
}
