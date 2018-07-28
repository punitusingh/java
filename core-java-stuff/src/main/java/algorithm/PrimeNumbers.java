package algorithm;

import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrimeNumbers {
    // Complete the primality function below.
    static String primality(int n) {
        if(n==1 || n==0) return "Not prime";
        if(n==2) return "Prime";
        int sqrt = Math.round((float)Math.sqrt(n));
        for(int i=2;i<=sqrt;i++){
            if(n%i == 0 ){
                return "Not prime";
            }
        }

        return "Prime";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileDescriptor.out));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
