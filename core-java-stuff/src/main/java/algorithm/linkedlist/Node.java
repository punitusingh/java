package algorithm.linkedlist;

public class Node<E>{
    Node<E> next;
    Node<E> prev;
    E value;
    Node(E value){
        this.value=value;
    }
}
