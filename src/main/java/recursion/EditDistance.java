package recursion;

/**
 * Given two string s1 and s2. perform any or all of 3 operations(insert, delete, replace) operarion on s1 to make it same as s2.
 * return min operations needed for same
 */
public class EditDistance {
    public static void main(String[] args) {
//        String s1 = "horse", s2 = "ros";
        String s1 = "ahellobye", s2 = "amezooe";

        //using 1 based indexing concept. where in place of passing s1.length()-1 I am passing s1.length and while
        //comparing char at string doing i-1 and j-1. so only if condition is i==0 else it would have been i<0
        int minOperations = minOperations(s1, s1.length(), s2, s2.length());
        System.out.println("recursion:"+minOperations);
    }

    private static int minOperations(String s1, int i, String s2, int j){
        if(i==0 && j==0) return 0;
        if(i==0){
            // i is exhausted but j is not/ example ("", -1, "ro", 1). In this case 2 insert operation is needed in s1
            // to make it compatible with s2 because j=1 means ro needs to be added in s1 as s1 is exhausted.
            return j+1;
        }
        if(j==0){
            // j is exhausted but i is not. example ("ho", 1, "", -1). In this case 2 delete operation is needed in s1
            // to make it compatible with s2 because i=1 means ho needs to be deleted from s1 as s2 is exhausted.
            return i+1;
        }

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return minOperations(s1, i-1, s2, j-1);
        }
        else{
            // assuming added new character to i+1 location of s1. then i+1 will be equal to j. so now need to compare
            //j-1 to i because i has compared with j and there was no match so only there was need to add new char at i+1.
            // so i is not moving. rather j need to decrement by 1 and compare with i;
            int insert = minOperations(s1, i-1, s2, j-1);

            // in case of delete char[i]!=char[j] so only hypothetically deleting char at i. so now i will decrement and
            // compare i-1 with j.
            int delete = minOperations(s1, i-1, s2, j);

            // in case of replace i!=j so replacing value of i with same value as value of j. now as we have replace value
            //hypothetically in ith position i will be equal to j and so both i and j will decrement by 1;
            int replace = minOperations(s1, i-1, s2, j-1);

            return Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }
}
