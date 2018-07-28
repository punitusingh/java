package algorithm.queue;

import algorithm.stack.Stack;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

public class ATaleOfTwoStacks {

    Deque<Integer> dequeNew = new ArrayDeque<>();
    Deque<Integer> dequeOld = new ArrayDeque<>();

    public void enque(int i){
        dequeNew.push(i);
    }


    public int peek(){
        switchStack();
       return dequeOld.peek();
    }


    public int deque(){
        switchStack();
       return dequeOld.pop();
    }

    public void switchStack(){

        if(dequeOld.isEmpty()){
            while(!dequeNew.isEmpty()){
                dequeOld.push(dequeNew.pop());
            }
        }
    }

    public boolean isEmpty(){
        return dequeNew.isEmpty() && dequeOld.isEmpty();
    }

    public static void main(String[] args) {
        ATaleOfTwoStacks aTaleOfTwoStacks=new ATaleOfTwoStacks();
        aTaleOfTwoStacks.enque(1);
        aTaleOfTwoStacks.enque(2);
        aTaleOfTwoStacks.enque(3);


        Assert.that(aTaleOfTwoStacks.peek() == 1,"first element should be 1");

        Assert.that(aTaleOfTwoStacks.deque() == 1, "first removed element should be 1");

        Assert.that(aTaleOfTwoStacks.deque() == 2, "second one should be 2");


        aTaleOfTwoStacks.enque(4);
        aTaleOfTwoStacks.enque(5);

        Assert.that(aTaleOfTwoStacks.deque() == 3, "third one should be 3");
        Assert.that(aTaleOfTwoStacks.deque() == 4, "then 4");
        Assert.that(aTaleOfTwoStacks.deque() == 5, "then 5");

        Assert.that(aTaleOfTwoStacks.isEmpty(), "now empty");
    }
}
