package algorithm.recursive;

public class AllSubsets {

    static class Count{
        int c=0;
    }

    static String[] subsets(String str){
        String[] strArray=new String[Double.valueOf(Math.pow(2,str.length())).intValue()];
        subsets(str, "", strArray,0, new Count());
        return strArray;
    }


    static void subsets(String str,String subset, String[] strArray, int index, Count count){
        if(index == str.length()){
            strArray[count.c++] = subset;
            return;
        }

        subsets(str,subset+str.charAt(index), strArray, index+1, count );
        subsets(str,subset, strArray, index+1, count );
    }


    public static void main(String[] args) {
        String[] subsets= subsets("abc");
        for(String s:subsets){
            System.out.println(s);
        }
    }
}
