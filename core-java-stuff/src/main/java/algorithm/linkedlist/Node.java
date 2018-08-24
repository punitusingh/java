package algorithm.linkedlist;

public class Node<E>{
    Node<E> next;
    E value;
    Node(E value){
        this.value=value;
    }

    Node next(E n){
        this.next=new Node<E>(n);
        return this.next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("next=").append(next);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
