package recursion.subset.partition;

public class ConsecutiveVariableLengthPartitioning {
    public static void main(String[] args){
        String str = "123";
        printConsecutivePartitions(str,"");
    }

    private static void printConsecutivePartitions(String str, String op){
        if(str.length() == 0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String prefix = str.substring(0, i+1);
            String suffix = str.substring(i+1);
            printConsecutivePartitions(suffix, op.length() == 0 ? prefix : op+" "+prefix);
        }
    }
}
