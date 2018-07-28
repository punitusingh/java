package algorithm.hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RansomNotes {
    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> map=new HashMap<String, Integer>();

        //dump all the magazine words in hashmap

        for(String s:magazine){
           if(!map.containsKey(s)){
               map.put(s,0);
           }

           map.put(s,map.get(s) + 1);

        }

        //loop over note, if all word present print Yes otherwise No
        for(String n:note){
            if(!map.containsKey(n) || map.get(n) == 0){
                System.out.println("No");
                return;
            }else{
                map.put(n, map.get(n) - 1);
            }
        }

        System.out.println("Yes");
    }


    public static void main(String[] args) {
        checkMagazine(new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "one", "grand", "today"}
        );

        checkMagazine(new String[]{"two", "times", "three", "is", "not", "four"},
               new String[]{ "two", "times", "two", "is", "four"});
    }
}
