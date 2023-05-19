package arrays;

//Todo
public class KadanesAlgorithm {
    public static void main(String[] args) {
        int arr[] ={-2,1,-3,4,-1,2,1,-5,4};

        //bruteforceSolution(arr);
        optimizedSol(arr);
    }

    private static void optimizedSol(int[] arr) {
        int max,sum, start, end, finalStart, finalEnd;
        max = sum = Integer.MIN_VALUE;
        finalStart = finalEnd = start = end = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum+=arr[i];
            end = i;
            if(max<sum){
                max = sum;
                finalStart = start;
                finalEnd = end;
            }
            else {

            }
        }
    }

    private static void bruteforceSolution(int[] arr) {
        int n = arr.length, i=0;
        int sum = Integer.MIN_VALUE;
        int start = 0 , end = 0, max = Integer.MIN_VALUE, maxStart=0, maxEnd=0, mainMax = Integer.MIN_VALUE;
        for(int j=0; j<n;j++) {
            start = j;
            i=j+1;
            sum = arr[j];
            for (; i < n; i++) {
                if (arr[i] < sum) {
                    max = sum;
                    end = start;
                    break;
                }
                sum += arr[i];
                if (max < sum) {
                    max = sum;
                    end = i;
                } else {
                    break;
                }
            }
            if(mainMax < max){
                mainMax = max;
                maxStart = start;
                maxEnd = end;
            }
            System.out.println("sum:"+sum+" start="+maxStart+" end="+maxEnd+ " mainMax="+mainMax);
        }
        if(mainMax > Integer.MIN_VALUE){
            System.out.println("sum:"+sum);
            for(i=maxStart; i<maxEnd; i++){
                System.out.println(arr[i]);
            }
        }
    }
}
