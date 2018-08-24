package algorithm.array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class MaxArraySumNonConsecutive {


    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        if(arr.length==0){return 0;}

        int prevTwo=0;
        int prevOne=0;
        int maxSum = 0;

        for(int i=0;i<arr.length;i++){
            maxSum = Math.max(prevOne, prevTwo + arr[i]);
            maxSum = maxSum > 0 ? maxSum : 0;
            prevTwo=prevOne;
            prevOne=maxSum;
        }

        return maxSum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println("res is "+ res);

        scanner.close();
    }
}
