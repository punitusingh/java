package algorithm.bit;

import java.util.Arrays;
import java.util.List;

public class LonelyInteger {
    static int findLonely(List<Integer> arr) {

        int thatNumber=0;

        for(Integer i : arr){
            thatNumber = thatNumber ^ i;
        }

        return thatNumber;
    }

    public static void main(String[] args) {
        System.out.println(findLonely(Arrays.asList(new Integer[]{0,0,1,2,1})));
    }
}
