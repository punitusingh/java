package algorithm.linkedlist;

public class LinkedListUtil {
    static void print(Node<Integer> node){
        while(node!=null){
            System.out.printf("%d---->",node.value);
            node=node.next;
        }
        System.out.println();
    }

    static Node<Integer> insertAll(int[] items){
        Node<Integer> head=new Node<>(items[0]);
        Node<Integer> node=head;

        for(int i=1;i<items.length;i++){
            node.next=new Node<>(items[i]);
            node=node.next;
        }
        return head;
    }
}
