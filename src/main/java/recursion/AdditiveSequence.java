package recursion;

import java.util.ArrayList;

/*
Given a string, the task is to find whether it contains an additive sequence or not.
A string contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers.
A valid string should contain at least three digit to make one additive sequence.

Input : s = “235813”
Output : true
2 + 3 = 5, 3 + 5 = 8, 5 + 8 = 13
 */
// requirement seems to be unclear to me. below is geeks for geeks code
public class AdditiveSequence {
    // Variable to store the result
    static boolean res;

    // Function to check the additive sequence
    static void check_additive(String s,
                               ArrayList<Integer> v,
                               int st) {

        // If the end is reached and vector
        // consists of more than 2 numbers then
        // one of the possible solution is found
        if (st == s.length() && v.size() > 2) {

            // Mark the res as true to indicate
            // the solution is found and
            // to avoid for trying
            // the rest of the combinations
            res = true;

            return;
        }

        int a = 0, b = 0, c = 0;
        if (v.size() >= 2) {

            // Store the previous two numbers
            // of the sequence to check the
            // additive sequence property
            // for the next number
            b = v.get(v.size() - 1);
            a = v.get(v.size() - 2);
        }

        for (int i = st; i < s.length(); i++) {

            // Generate the number
            c = c * 10 + (s.charAt(i) - '0');

            // Try all the possible ways
            // to generate the first two numbers
            // i.e. if vector consists of
            // less than two numbers and
            // no solution is found yet
            if (v.size() < 2 && !res) {
                v.add(c);
                check_additive(s, v, i + 1);

                // Pop the value to try for the
                // other combination
                v.remove(v.size() - 1);
            }

            // If the number generated so far
            // is greater than the sum of
            // previous two numbers in
            // the sequence then it cannot be
            // a part of additive sequence
            // hence no need to proceed further
            else if (c > (a + b) && !res)
                return;

                // If the number generated so far
                // is equal to the sum of
                // previous two numbers then
                // it can be a part of additive
                // sequence; push it into vector
                // and check for remaining String
            else if (c == a + b && !res) {

                // Store it in the vector
                v.add(c);

                // Recur for remaining String
                check_additive(s, v, i + 1);

                // If unable to find solution
                // pop it and try for
                // other combination
                v.remove(v.size() - 1);
            }
        }
        return;
    }

    // Function to check if additive sequence
    static boolean isAdditiveSequence(String str)
    {

        // In order to form additive sequence
        // the length of the String
        // must be atleast three
        if (str.length() <= 2)
            return false;

        ArrayList<Integer> v = new ArrayList<Integer>();
        res = false;
        check_additive(str, v, 0);
        return res;
    }

    // Driver code
    public static void main(String args[]) {
        String str = "199111099";
        boolean ans = isAdditiveSequence(str);
        if (ans)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
