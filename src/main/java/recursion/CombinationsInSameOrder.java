package recursion;

public class CombinationsInSameOrder {
    public static void main(String[] args) {
        String str = "1234";
        //printCombinationsInSameOrder(str, "", 0);
        //printCombinationsInSameOrder("1", str.substring(1), "");
        //printCombinationsInSameOrder("12", str.substring(2), "");
        //printCombinationsInSameOrder("123", str.substring(3), "");

        char input[] = str.toCharArray();
        char []output = new char[str.length()+4];

        printCombinations(input, 0, output, 0);
    }

    private static void printCombinationsInSameOrder(String str, String op, int i) {
        if(str.length()==0){
            System.out.println(op+" "+str);
            return;
        }
        char c = str.charAt(i);
        String s1 = str.substring(i+1);
        printCombinationsInSameOrder(s1, op+c, i);
        printCombinationsInSameOrder(op, s1+c,i+1);

        System.out.println(op+c+" "+s1);
    }

    static void printCombinations(char[] input,
                                  int index,
                                  char[] output,
                                  int outLength)
    {
        // no more digits left in input string
        if (input.length == index)
        {
            // print output string & return
            System.out.println(String.valueOf(output));
            return;
        }

        // place current digit in input string
        output[outLength] = input[index];

        // separate next digit with a space
        output[outLength + 1] = ' ';

        printCombinations(input, index + 1, output,
                outLength + 2);

        // if next digit exists make a
        // call without including space
        if(input.length!=index + 1)
            printCombinations(input, index + 1, output,
                    outLength + 1);
    }

}
