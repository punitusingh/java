package algorithm.string;

public class MakingAnagram {

   static int[] getCharCounts(String str){
        int[] counts = new int[26];
        int aValue=(int)'a';
        for(char c: str.toCharArray()){
            counts[c - aValue]++;
        }

        return counts;
    }


    static int makeAnagram(String a, String b){

        int[] charCountsA=getCharCounts(a);
        int[] charCountsB=getCharCounts(b);


        int delta=0;
        for(int i=0;i<charCountsA.length;i++){
            delta = delta + Math.abs(charCountsB[i] - charCountsA[i]);
        }


        return delta;
    }


    public static void main(String[] args) {
        System.out.println(makeAnagram("cde","abc"));
    }
}
