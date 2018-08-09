package algorithm.array;

import java.util.Scanner;

public class MaxSumSubArray {

    static int getNextIndex(int jump, int i, int size){
        return (i + jump) % size;
    }

    static int maxSumOf(int[] array, int noOfElements){

        noOfElements=Math.min(noOfElements, array.length);

        int max=0;

        for(int i=0;i<array.length;i++){
            int sum = array[i];
            for(int j=1;j<noOfElements;j++){
                sum = sum +  array[getNextIndex(j,i,array.length)];
            }
            max = Math.max(sum, max);
        }

        return max;
    }

    static int anotherMaxSumOf(int[] array, int window){
        window=Math.min(window, array.length);

        int maxSoFar = 0;

        for(int i=0;i<window;i++){
            maxSoFar = maxSoFar + array[i];
        }
        int max = maxSoFar;

        for(int i=1;i < array.length; i++){
            maxSoFar = maxSoFar - array[i-1] + array[(i + window - 1)%array.length];
            max = Math.max(max, maxSoFar);
        }

        return maxSoFar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(anotherMaxSumOf(new int[]{12,3,4,5},2));

        /*int queries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] arrays = new int[queries][];
        int[] ns = new int[queries];
        for(int i=0;i<queries;i++){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            ns[i] = n;
            int[] array = new int[m];
            int index=0;
            while(m-- > 0){
                array[index] = scanner.nextInt();
                index++;
            }
            arrays[i] = array;

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        for(int i=0;i<arrays.length;i++){
            System.out.println(maxSumOf(arrays[i],ns[i]));
        }
        scanner.close();*/
    }

}
