package algorithm.string;

public class LongestSubstringWithoutDuplicateChar {


    static String longestSubString(String str){
        if(str==null || str.length() == 1 ){
            return str;
        }
        StringBuilder  longest=new StringBuilder();
        boolean[] cache = new boolean[256];


        int start=0;
        int end=0;
        int length=str.length();

        while(end < length){
            char c=str.charAt(end);
            //if not seen
            if(!cache[c]){
                // see it
                cache[c]=true;
                //consider it
                longest.append(c);
            }else{
                //if seen, move start to end
                longest.setLength(0);
                longest.append(c);
                while(start < end){
                    char t=str.charAt(start);
                    if(t != c){
                        cache[t]=false;
                    }
                    start++;
                }

            }

            end++;
        }


        return longest.toString();
    }

    public static void main(String[] args) {
       System.out.println(longestSubString("abccdefgh"));
       System.out.println(longestSubString("abac"));
       System.out.println(longestSubString("aaaaa"));
    }
}
