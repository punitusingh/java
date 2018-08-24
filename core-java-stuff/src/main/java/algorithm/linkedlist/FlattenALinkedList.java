package algorithm.linkedlist;

public class FlattenALinkedList {


    static class Node{
        int value;
        Node next;
        Node child;
        public Node(int value){
            this.value=value;
        }
    }

    static void flatten(Node head){
        Node tail=head;
        Node curr=head;
        while(tail.next!=null){
            tail=tail.next;
        }

        while(curr!=tail){

            if(curr.child!=null){
                tail.next=curr.child;
                curr.child=null;

                while(tail.next!=null){
                    tail=tail.next;

                }
            }

            curr=curr.next;
        }
    }

    static void print(Node head){
        while (head!=null){
            System.out.print("\t"+head.value);
            head=head.next;
        }
    }

    public static void main(String[] args) {

        Node head=new Node(1);

        head.next=new Node(2);
        head.next.child=new Node(5);
        head.next.child.next=new Node(6);
        head.next.child.child=new Node(8);

        head.next.next=new Node(3);

        head.next.next.next=new Node(4);

        head.next.next.next.child=new Node(7);

        head.next.next.next.child.child=new Node(9);

        flatten(head);
        print(head);
    }
}
