package algorithm.heap;

import javax.validation.constraints.Min;
import java.util.Arrays;

public class MinItemHeap {

   private int capacity=10;

   private int size=0;

   private int[] items=new int[capacity];


    public void add(int item){
        ensureExtraCapacity();

        //add in bottom
        items[size] = item;

        //increase size
        size++;

        //heapifyUp
        heapifyUp();
    }

    public int peek(){
        if(size == 0){ throw new IllegalStateException();}
        return items[0];
    }

    public MinItemHeap clone(){
        MinItemHeap heap=new MinItemHeap();
        heap.size = this.size;
        heap.items = this.items.clone();
        heap.capacity=this.capacity;
        return heap;
    }


    public boolean hasNext(){
        return size!=0;
    }

    public int poll(){
        //if no item throw error
        if(size == 0){ throw new IllegalStateException();}
        //take the first item
         int item=items[0];
        //move last item to first place
        items[0] = items[size-1];
        //decrease size
        size--;
        //heapifyDown now
        heapifyDown();
        return item;
    }


    public void heapifyUp(){
        //means new item added in the end of the array
        //it should be moved one by one
        //get the parent, if parent is present, and if parent is greater, then swap with child
        int index=size-1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(parentIndex(index), index);
            index=parentIndex(index);
        }

    }


    public void heapifyDown(){
        int index=0;
        while (hasLeftChild(index)){
            int smallerChildIndex=leftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex=rightChildIndex(index);
            }

            if(items[smallerChildIndex] < items[index]){
                swap(smallerChildIndex, index);
            }else{
                break;
            }

            index=smallerChildIndex;
        }
    }

    private void swap(int index1, int index2){
        int temp=items[index1];
        items[index1]=items[index2];
        items[index2]=temp;
    }

    private void ensureExtraCapacity(){
        if(capacity == size){
            capacity=2*capacity;
            items= Arrays.copyOf(items, capacity);
        }
    }

    private int parentIndex(int index){
        return (index-1)/2;
    }

    private int leftChildIndex(int index){
        return (2*index + 1);
    }

    private int rightChildIndex(int index){
        return (2*index + 2);
    }

    private boolean hasParent(int index){
        return parentIndex(index)>=0;
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) < size;
    }


    private int parent(int index){
        return items[parentIndex(index)];
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    public void printMedian(){
        MinItemHeap clone=this.clone();
        float[] sortedArray = new float[clone.size];
        int i=0;
        while(clone.hasNext()){
            sortedArray[i++] = clone.poll();
        }

        int n=sortedArray.length;
        if(n % 2 == 0 ){
            System.out.println(((sortedArray[n/2-1]) + sortedArray[n/2])/2);
        }else{
            System.out.println(sortedArray[n/2]);
        }
    }


    public static void main(String[] args) {
        MinItemHeap minItemHeap=new MinItemHeap();
        minItemHeap.add(100);
        minItemHeap.printMedian();
        minItemHeap.add(50);
        minItemHeap.printMedian();
        minItemHeap.add(80);
        minItemHeap.printMedian();
        minItemHeap.add(75);
        minItemHeap.printMedian();
        minItemHeap.add(40);
        minItemHeap.printMedian();
        minItemHeap.add(10);
        minItemHeap.printMedian();


//        while (minItemHeap.hasNext()){
//            System.out.println(minItemHeap.poll());
//        }

    }
}
