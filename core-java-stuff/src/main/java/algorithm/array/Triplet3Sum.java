package algorithm.array;

import java.util.HashSet;
import java.util.Set;

public class Triplet3Sum {

   static boolean is3Sum(int[] array,int sum){
        if(array==null || array.length<3){
            return false;
        }

        if(array.length == 3 ){
            return array[0] + array[1] + array[2] == sum;
        }




        for(int i=0;i<array.length-2;i++){

            int twoSum=sum-array[i];

            Set<Integer> set=new HashSet<>();

            for(int j=i+1;j<array.length;j++){
                int thirdNumberNeeded = twoSum - array[j];
                if(set.contains(thirdNumberNeeded)){
                    return true;
                }
                set.add(array[j]);
            }

        }



        return false;
    }


    public static void main(String[] args) {

        System.out.println(is3Sum(new int[]{12,4,1,3,6,9}, 15));
    }

}
