package algorithm.string;

public class SumOfLargeNumbers {


    static String sumStrings(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;
        String res = "";
        while(i>=0 || j>=0 || carry==1) {
            carry += i>=0 ? (a.charAt(i--) - '0') : 0;
            carry += j>=0 ? (b.charAt(j--) - '0') : 0;

            res = (char)(carry%10 + '0') + res;
            carry = carry/10;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(sumStrings("45","9"));
    }
}
