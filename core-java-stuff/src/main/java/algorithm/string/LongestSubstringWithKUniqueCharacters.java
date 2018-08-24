package algorithm.string;

public class LongestSubstringWithKUniqueCharacters {

    static String longestSubString(String str, int k){
        if(str==null || str.length() == 1 ){
            return null;
        }
        int[] count = new int[256];


        int start=0;
        int end=0;
        int maxTillNow=0;
        int maxEnd=0, maxStart=0;

        int length=str.length();

        while(end < length){
            char c=str.charAt(end);

            //maintain the count of each char
            count[c-'a']++;
            end++;

            //if unique char count is >k then move start pointer forward, until it unique char count <= k
            while(uniqueCharCountGreaterThanK(count,k)){
              count[str.charAt(start) - 'a']--;
              start++;
            }


            //only book-keeping
            //if end-start > maxTillNow, update maxTillNow, update maxEnd, update maxStart
            int currentSubStrLength=end-start;
            if(currentSubStrLength > maxTillNow){
                maxTillNow = currentSubStrLength;
                maxEnd=end;
                maxStart=start;
            }

        }


        return str.substring(maxStart, maxEnd);
    }

    static boolean uniqueCharCountGreaterThanK(int[] count, int k){
        int uniqueChar=0;
        for(int i:count){
            if(i>0){
                uniqueChar++;
                if(uniqueChar > k){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("aabacbebebe", 3));
    }
}
