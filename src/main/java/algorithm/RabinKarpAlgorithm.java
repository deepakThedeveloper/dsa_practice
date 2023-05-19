package algorithm;

// todo: this code doesn't work for base 26.
public class RabinKarpAlgorithm {
    // sample values I have taken where I have assigned certain characteres number i.e. a=1,b=2 likewise
    static char[] exampleValues = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
    'w','x','y','z'};
    public static void main(String[] args) {
        char[] a = {'c','c','a','c','c','a','a','e','d','b','a'};
        char[] b = {'d','b','a'};

        int hashCodeOfB = 0; //d-4*26^2 + b-2*26^1 + a-1*26^0;
        int hashCodeOfAOfBLength = 0;
        int aStart = 0, aEnd = b.length-1;
        for(int i=0; i<b.length; i++){
            int n = (b.length-(i+1));
            hashCodeOfB += (int) ((b[i] - 97 + 1)*Math.pow(26,n));
            hashCodeOfAOfBLength += (int) ((a[i] - 97 + 1)*Math.pow(26,n));
        }

        boolean flag = true;
        for(int i=b.length; i<=a.length; i++){
            if(hashCodeOfAOfBLength == hashCodeOfB){
                if(compareCharacters(aStart, aEnd, b, a)){
                    flag = true;
                    break;
                }
            }
            else{
                if(i==a.length){
                    flag = false;
                    break;
                }
                int temp = (int) ((((int)a[aStart])-97+1)*Math.pow(26, b.length-1));
                int temp2 = (hashCodeOfAOfBLength - temp)*26;
                int nextHash = (int) ((a[i]-97+1)*Math.pow(26,0));
                hashCodeOfAOfBLength = (temp2 + nextHash);
                aStart=aEnd+1;
                aEnd+=1;
            }
        }
        if(flag){
            System.out.println("match found break");
        }
        else{
            System.out.println("match not found");
        }
    }
    private static boolean compareCharacters(int i, int j, char[] b, char[] a){
        while (i<=j){
            if(a[i] != b[i]) return false;
            i++;
            j++;
        }
        return true;
    }
}
