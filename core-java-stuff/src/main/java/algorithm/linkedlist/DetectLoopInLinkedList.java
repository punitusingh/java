package algorithm.linkedlist;

public class DetectLoopInLinkedList {


    static boolean isCycle(Node head){
        if(head==null || head.next==null){
            return false;
        }
        Node turtle=head;
        Node rabbit=head.next;


        while (turtle!=null && rabbit.next!=null){


            if(turtle == rabbit){
                return true;
            }

            turtle=turtle.next;
            rabbit=rabbit.next.next;
        }


        return false;
    }


    public static void main(String[] args) {
        //1->2->3->4->5->6->4
        Node head=new Node<Integer>(1);
        Node cycleNode = head.next(2).next(3).next(4);
        Node lastNode = cycleNode.next(5).next(6);
        lastNode.next = cycleNode;



        System.out.println(isCycle(head));


        System.out.println(isCycle(new Node<Integer>(1).next(2).next(3).next(4)));


        System.out.println(isCycle(new Node<Integer>(1)));
    }

}
