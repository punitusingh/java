package algorithm.linkedlist;

public class Node<E>{
    Node<E> next;
    E value;
    Node(E value){
        this.value=value;
    }

    Node next(E n){
        this.next=new Node<E>(n);
        return this;
    }

}
