package algorithm.linkedlist;

public class ReverseLinkedList {


    public static void main(String[] args) {
        Node<Integer> head=createALinkedList();

        Node<Integer> next = reverseIt(head);
        while(next!=null){
            System.out.println(next.value);
            next=next.next;
        }
    }


    private static Node<Integer> reverseRec(Node<Integer> node){
        //node.next == null, means recurse till second last element only
        if(node==null || node.next==null){return node;}
        Node<Integer> head=reverseRec(node.next);

        //node.next means last, then last.next=node, means arrow reversed
        node.next.next=node;
        node.next=null;

        return head;
    }

    private static Node<Integer> reverseIt(Node<Integer> head) {
        Node<Integer> prev=head;
        Node<Integer> curr=head.next;
        Node<Integer> temp=null;

        while(curr!=null){
             temp=curr;
             curr=curr.next;
             temp.next=prev;
             prev=temp;
        }

        head.next=null;
        return prev;
    }

    private static Node<Integer> createALinkedList() {

        Node<Integer> head=insertNode(1,null);
        head=insertNode(2,head);
        head=insertNode(3,head);
        head=insertNode(4,head);

        return head;
    }

    private static Node<Integer> insertNode(int i, Node<Integer> head) {
        if(head==null){
            return new Node<>(i);
        }

        Node<Integer> next=head;

        while(next.next!=null){
            next=next.next;
        }

        next.next=new Node<>(i);
        return head;
    }
}
