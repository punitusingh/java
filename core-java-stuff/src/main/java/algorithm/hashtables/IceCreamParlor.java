package algorithm.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IceCreamParlor {

    static int getIndex(int[] menu, int item, int excludeIndex){
        for(int i=0;i<menu.length;i++){
            if(menu[i] == item && i!=excludeIndex){
                return i;
            }
        }

        return -1;
    }


    static int[] getIndexes(int[] menu, int item1, int item2){
        int index1 = getIndex(menu,item1,-1);
        int index2= getIndex(menu, item2,  index1);

        return new int[]{Math.min(index1,index2), Math.max(index1,index2)};
    }

    static void whatFlavors(int[] menu, int money) {

       int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);


        for(int i=0;i<sortedMenu.length;i++){
            int price=money-sortedMenu[i];
            int index=Arrays.binarySearch(sortedMenu,i+1, sortedMenu.length, price);
            if(index>=0){
                int[] indexes=getIndexes(menu, sortedMenu[i], sortedMenu[index]);
                System.out.println((indexes[0]+1) + " "+ (indexes[1]+1));
                return;
            }
        }

    }


    public static void main(String[] args) {
        whatFlavors(new int[]{1,4,5,3,2},4);
        whatFlavors(new int[]{2,2,4,3},4);
    }
}
