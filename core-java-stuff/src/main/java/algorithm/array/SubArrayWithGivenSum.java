package algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {


    static int findIndexPlusOne(int[] arr, int index, int sum){
        if(sum == 0) return 1;

        if(sum < 0 || index==arr.length) return 0;


        int count=0;
       // int lookUpLimit = index == 0 ? arr.length : Math.min(arr.length, index+2);
        for(int i=index;i<arr.length;i++){
            count = count + findIndexPlusOne(arr, i+1, sum-arr[i]);
        }
        return count;
    }

    static int findInclExcl(int[] arr, int index, int sum){
        if(sum == 0) return 1;
        if(sum < 0 || index==arr.length) return 0;

        return findInclExcl(arr,index+1, sum) + findInclExcl(arr, index+1, sum - arr[index]);
    }

    static int contiguousSum(int[] arr, int sum){

        int slidingWindowSum = arr[0];
        int start=0;
        int end = 0;
        int count = 0;

        while(start < arr.length){
             if(slidingWindowSum <= sum){
                if(slidingWindowSum == sum){
                    count++;
                }
                if(end == arr.length - 1){
                    break;
                }
                end++;
                slidingWindowSum = slidingWindowSum + arr[end];
            }else if(slidingWindowSum > sum){
                while(slidingWindowSum > sum){
                    slidingWindowSum = slidingWindowSum - arr[start];
                    start++;
                }
            }
        }

        return count;
    }

    static List<String> arrayWithSum(int[] arr, int sum){
        List<String> results=new ArrayList<>();

        arrayWithSum(arr, sum, 0, results, "");

        return results;
    }

    static void arrayWithSum(int[] arr, int sum, int index,  List<String> results, String str){
        if(sum == 0){
            results.add(str);
            return ;
        }

        if(sum<0 || index>=arr.length){
            return ;
        }

         arrayWithSum(arr, sum-arr[index], index+1, results, str+"~"+arr[index]);
         arrayWithSum(arr, sum, index+1, results, str);

    }

    static void print(String msg, int index){
        for(int i=0;i<index;i++){
            System.out.print("\t");
        }

        System.out.print(msg);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(findIndexPlusOne(new int[]{1,2,3,4}, 0 , 4));
        System.out.println(findInclExcl(new int[]{1,2,3,4}, 0 , 4));
        System.out.println(contiguousSum(new int[]{1,2,3,4}, 4));

        System.out.println(arrayWithSum(new int[]{1,2,3,4}, 4));

    }
}
