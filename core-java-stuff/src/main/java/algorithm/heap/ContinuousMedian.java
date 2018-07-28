package algorithm.heap;


import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {



    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){

        //if lower is empty, or number is smaller then lowers peek
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        }else{
            highers.add(number);
        }

    }


    public static PriorityQueue<Integer> getBigger(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        return lowers.size() < highers.size() ? highers: lowers;
    }

    public static PriorityQueue<Integer> getSmaller(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        return lowers.size() < highers.size() ? lowers: highers;
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        //decide which one is bigger, and which one is smaller
        PriorityQueue<Integer> bigger=getBigger(lowers,highers);
        PriorityQueue<Integer> smaller=getSmaller(lowers,highers);
        //check the difference for more than one
        if(bigger.size() - smaller.size() > 1){
            smaller.add(bigger.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        //decide which one is bigger, and which one is smaller
        PriorityQueue<Integer> bigger=getBigger(lowers,highers);
        PriorityQueue<Integer> smaller=getSmaller(lowers,highers);

        if(bigger.size() > smaller.size()){
            return bigger.peek();
        }else{
            return ((double)bigger.peek() + smaller.peek())/2;
        }
    }

    public static void main(String[] args) {


        int[] array={12, 4, 5, 3, 8, 7};

        //heap to keep lower half, max heap
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1* o1.compareTo(o2);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        for(int i=0;i<array.length;i++){
            //first add in currect bucket
            addNumber(array[i], lowers, highers);
            //rebalance it
            rebalance(lowers,highers);
            //then get the median
            System.out.println(getMedian(lowers, highers));
        }


    }
}
