package algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpecialEquivalient {
    private int count = 0;

    SpecialEquivalient (String[] input) {
        Set<String> outputSet = new HashSet<String>();;
        for(String str : input) {
            String[] evenOdd = splitEvenOdd(str);
            String sortedString = sortString(evenOdd[0]) + sortString(evenOdd[1]);
            outputSet.add(sortedString);
            print(evenOdd);
            System.out.printf("\nsortedString: %s, outputSet:%s", sortedString, outputSet);
        }
        count = outputSet.size();
    }

    void print(String[] evenOdd){
        System.out.println();
        System.out.println();
        System.out.print("evenOdd :: \t");
        for(String s:evenOdd){
            System.out.print(s+"\t");
        }
    }


    String[] splitEvenOdd(String str) {
        char[] chars = str.toCharArray();
        String odd = new String();
        String  even = new String();
        for (int i=0; i<str.length(); i++) {
            if (i % 2 == 1) {
                odd += chars[i];
            } else {
                even += chars[i];
            }
        }
        return new String[] {odd, even};
    }

    String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public int uniqueCount() {
        return count;
    }

    public static void main(String[] args) {
       // System.out.println(new SpecialEquivalient(new String[]{"abcd","cbad","bacd"}).uniqueCount());
       System.out.println(new SpecialEquivalient(new String[]{"abcd", "acbd", "adcb", "cdba",
                "bcda", "badc"}).uniqueCount());
    }
}
