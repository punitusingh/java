package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(2);
        System.out.println(list.size());
        list.add(list.size(),5);
        list.add(list.size(),5);
        list.add(list.size(),5);
        list.add(list.size(),5);
        System.out.println(list.size());
    }
}
