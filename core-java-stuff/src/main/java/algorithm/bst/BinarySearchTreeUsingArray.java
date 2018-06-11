package algorithm.bst;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeUsingArray {



    BinarySearchTreeUsingArray(){
    }

    void insertAllIterative(int[] items){
            int length=items.length;

            List<Integer> tree=new ArrayList<>();

            tree.add(items[0]);


            for(int i=1;i<length;i++){
                int value=items[i];


            }


    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr=new int[n];
//        int i=0;
//
//        while(i < n){
//            arr[i] = sc.nextInt();
//            i++;
//        }

        BinarySearchTreeUsingArray bst=new BinarySearchTreeUsingArray();
      //  main.java.algorithm.bst.insertAllIterative(arr);
        bst.insertAllIterative(new int[]{3,5,1,6,8,7,2,4});
    }

}
