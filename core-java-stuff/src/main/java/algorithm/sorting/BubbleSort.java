package algorithm.sorting;

public class BubbleSort {


    public static void sort(int[] a){

        boolean isSorted=false;
        int lastSortedIndex = a.length - 1;
        int numSwaps = 0;
        while(!isSorted){
            isSorted=true;
            for(int i=0; i < lastSortedIndex; i ++){
                if(a[i] > a[i+1]){
                    swap(a,i,i+1);
                    numSwaps++;
                    isSorted=false;
                }
            }

            lastSortedIndex--;
        }



        System.out.println("Array is sorted in "+ numSwaps +" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+ a[a.length-1]);
    }


    public static void swap(int[] a, int index1, int index2){
        int temp=a[index1];
        a[index1]=a[index2];
        a[index2]=temp;
    }


    public static void main(String[] args) {
        sort(new int[]{3,2,1});
    }

}
