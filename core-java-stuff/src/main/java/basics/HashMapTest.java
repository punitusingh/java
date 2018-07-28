package basics;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map=new HashMap<String, String>();

        map.put("g3","3");//12
        map.put("e1","1");//12
        map.put("f2","2");//12
        map.put("c6","6");//3
        map.put("d7","7");//3
        map.put("a4","4");//3
        map.put("b5","5");//3





        for(Map.Entry<String, String> entry:map.entrySet()){
            System.out.println(entry);
        }
    }
}
