package recursion.combination;

public class PrintNumberCombinations {
    public static void main(String[] args) {
        String n = "1234";
        printCombinations("", n, "");
    }

    private static void printCombinations(String ip, String n, String op) {
        if(n.length()==0){
            //System.out.println(ip+" "+op);
            return;
        }
        for(int i=0; i<n.length(); i++){
            char c = n.charAt(i);
            String s1 = n.substring(i+1);
            String ip1 = n.substring(0,i);
            printCombinations(ip+ip1, s1, op+c);
            if(op.length()>=1) {
                System.out.println(ip+" "+op+" "+n);
                return;
            }
        }
    }
}
