package algorithm.linkedlist;

public class PartitionAroundX {

    static Node<Integer> head;

    static Node<Integer> partition(Node<Integer> node, int x){
        //x=5
        Node<Integer> head=node;//3
        Node<Integer> tail=node;//3

        while(node!=null){
            Node<Integer> next=node.next;//5
            if(node.value < x){ //3 < 5
                node.next=head; //3---->3
                head = node; //head--->3
            }else{
                //5===5
                tail.next=node;//3-->5
                tail = node; //tail--->5
            }
            node=next;
        }

        tail.next=null;
        return head;
    }

    public static void main(String[] args) {
        head=LinkedListUtil.insertAll(new int[]{3,5,8,5,10,2,1});
        LinkedListUtil.print(head);
        Node<Integer> newHead=partition(head,5);
        System.out.println("\npartitioned....");
        LinkedListUtil.print(newHead);

        /*
         *
         * head = 3 = tail
         *
         * 5
         * head = 3 ----> 5 = tail
         *
         * 8
         * head = 3 ----> 5 ----> 8 = tail
         *
         * 5
         * head = 3 ----> 5 ----> 8 ----> 5 = tail
         *
         * 10
         * head = 3 ----> 5 ----> 8 ----> 5 ----> 10 = tail
         *
         * 2
         * head = 2 ----> 3 ----> 5 ----> 8 ----> 5 ----> 10 = tail
         *
         * 1
         * head = 1 ----> 2 ----> 3 ----> 5 ----> 8 ----> 5 ----> 10 = tail
         */
    }

}
