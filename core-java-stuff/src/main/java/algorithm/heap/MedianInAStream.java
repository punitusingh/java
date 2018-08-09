package algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInAStream {

    static void addNumber(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        if(maxHeap.isEmpty() || number < maxHeap.peek()){
            maxHeap.add(number);
        }else{
            minHeap.add(number);
        }
    }


    static PriorityQueue<Integer> smaller(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        return maxHeap.size() < minHeap.size()? maxHeap: minHeap;
    }

    static PriorityQueue<Integer> bigger(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        return maxHeap.size() < minHeap.size()? minHeap: maxHeap;
    }

    static void rebalance(PriorityQueue<Integer> smaller, PriorityQueue<Integer> bigger){
        if((bigger.size() - smaller.size()) > 1){
            smaller.add(bigger.poll());
        }
    }

    static int getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        PriorityQueue<Integer> smaller = smaller(minHeap,maxHeap);
        PriorityQueue<Integer> bigger = bigger(minHeap,maxHeap);

        rebalance(minHeap,maxHeap);

        if(smaller.size() == bigger.size()){
            return (smaller.peek() + bigger.peek()) / 2;
        }else if(smaller.size() < bigger.size()){
            return bigger.peek();
        }

        return smaller.peek();
    }

    static void median(int[] array){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i< array.length;i++){
           addNumber(array[i], minHeap, maxHeap);
           System.out.println(getMedian(minHeap, maxHeap));
        }

    }


    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int queries = scanner.nextInt();
        int[] array=new int[queries];
        for(int i=0;i<queries;i++){
            array[i] = scanner.nextInt();
        }


        median(array);
       // median(new int[]{9384,887});

        scanner.close();

    }
}
