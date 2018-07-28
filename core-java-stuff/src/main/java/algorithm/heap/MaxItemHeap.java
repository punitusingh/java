package algorithm.heap;

import java.util.Arrays;

public class MaxItemHeap {
    int capacity=10;
    int size=0;
    int[] items = new int[capacity];


    public void add(int item){
        //before adding, ensureExtraCapacity
        ensureExtraCapacity();

        //add at the end
        items[size]=item;

        //increase size
        size++;

        //heapifyUp
        heapifyUp();
    }

    public boolean hasNext(){
        return size>0;
    }

    public int peek(){
        //if no item, throw error;
        if(size==0){throw new IllegalStateException();}
        //return firstItem
        return items[0];
    }

    public int poll(){
        //if size=0, error
        if(size==0){throw new IllegalStateException();}
        //get first item,
        int item=items[firstIndex()];
        //move last item into first item
        items[firstIndex()]=items[lastIndex()];
        //decrease size
        size--;
        //heapifyDown()
        heapifyDown();
        return item;
    }

    public void ensureExtraCapacity(){
        //if size reached to boundary
        if(size == capacity){
            //double it
            capacity=capacity*2;
            items= Arrays.copyOf(items,capacity);
        }

    }


    public void swap(int index1, int index2){
        //get first item in temp
        int temp=items[index1];
        //put second item in first
        items[index1]=items[index2];
        //put temp in second item
        items[index2]=temp;
    }


    public void heapifyUp(){
        //means we are at the bottom

        //take the last item, and it's index
        int index=lastIndex();

        //while parent item is smaller,
        while(hasParent(index) && parent(index) < items[index]) {
            //  swap with parent
            swap(parentIndex(index), index);
            //  update the index
            index=parentIndex(index);
        }

    }

    public void heapifyDown(){
        //take the first item
        int index=0;
        //max heap, so parent should be greater then childrens

        while(hasLeftChild(index)){
            int greaterChildIndex=leftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)){
                greaterChildIndex=rightChildIndex(index);
            }

            if(items[greaterChildIndex] > items[index] ){
                swap(greaterChildIndex,index);
            }else{
                break;
            }

            index=greaterChildIndex;

        }

    }

    public int firstIndex(){
        return 0;
    }

    public int lastIndex(){
        return size-1;
    }

    private int parentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasParent(int childIndex){
        return parentIndex(childIndex) >=0;
    }

    private int parent(int childIndex){
        return items[parentIndex(childIndex)];
    }

    private int leftChildIndex(int parentIndex){
        return (2*parentIndex + 1);
    }

    private boolean hasLeftChild(int parentIndex){
        return leftChildIndex(parentIndex) < size;
    }

    private int leftChild(int parentIndex){
        return items[leftChildIndex(parentIndex)];
    }

    private int rightChildIndex(int parentIndex){
        return (2*parentIndex + 2);
    }

    private boolean hasRightChild(int parentIndex){
        return rightChildIndex(parentIndex) < size;
    }

    private int rightChild(int parentIndex){
        return items[rightChildIndex(parentIndex)];
    }

    public static void main(String[] args) {
        MaxItemHeap maxItemHeap=new MaxItemHeap();
        maxItemHeap.add(100);
        maxItemHeap.add(50);
        maxItemHeap.add(80);
        maxItemHeap.add(75);
        maxItemHeap.add(40);
        maxItemHeap.add(10);



        while (maxItemHeap.hasNext()){
            System.out.println(maxItemHeap.poll());
        }
    }
}
