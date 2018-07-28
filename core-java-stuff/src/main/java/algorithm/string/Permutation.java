package algorithm.string;

public class Permutation {


    public static void permute(char[] str, int swapCharIndex){
        if(swapCharIndex==str.length-1){
            System.out.println( str );
        }

        for(int i=swapCharIndex;i<str.length;i++){
            swap(str,i,swapCharIndex);
            permute(str,swapCharIndex+1);
            swap(str,swapCharIndex,i);
        }
    }

    private static void swap(char[] chars, int index1, int index2){
        char temp=chars[index1];
        chars[index1] = chars[index2];
        chars[index2]=temp;
    }

    public static void main(String[] args) {
        permute("ABCD".toCharArray(),0);
    }
}
