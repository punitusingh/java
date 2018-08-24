package algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindMergePointOfTwoLists {

    static void printTab(int i){
        while(i>0){
            System.out.print("\t");
            i--;
        }
    }

    static Integer mergePointUsingSet(Node<Integer> head1, Node<Integer> head2){
        if(head1.value.equals(head2.value)){
            return head1.value;
        }
        Set<Integer> set=new HashSet<>();
        set.add(head1.value);
        set.add(head2.value);
        int i=0;
        while(head1.next!=null && head2.next!=null){
            i++;
            printTab(i);
            System.out.println("set is ===>"+set);
            head1=head1.next;
            head2=head2.next;
            printTab(i);
            System.out.println("head1 ===>"+head1);
            printTab(i);
            System.out.println("head2 ===>"+head2);
            if(set.contains(head1.value)){
                return head1.value;
            }else if(set.contains(head2.value)){
                return head2.value;
            }
            set.add(head1.value);
            set.add(head2.value);
        }

        return -1;
    }

    static int getLength(Node head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }

        return i;
    }

    static Integer mergePointUsingDelta(Node<Integer> head1, Node<Integer> head2){
        int lengthOfFirstLinkedList=getLength(head1);
        System.out.println("lengthOfFirstLinkedList===>"+lengthOfFirstLinkedList);
        int lengthOfSecondLinkedList=getLength(head2);
        System.out.println("lengthOfSecondLinkedList===>"+lengthOfSecondLinkedList);

        int delta=Math.abs(lengthOfFirstLinkedList-lengthOfSecondLinkedList);

        Node<Integer> smallerList=null;
        Node<Integer> largerList=null;
        if(lengthOfFirstLinkedList>lengthOfSecondLinkedList){
            smallerList=head2;
            largerList=head1;
        }else{
            smallerList=head1;
            largerList=head2;
        }

        while (delta>0){
            largerList=largerList.next;
            delta--;
        }

        while (largerList!=null && smallerList!=null){
            if(largerList.value.equals(smallerList.value)){
                return largerList.value;
            }

            largerList=largerList.next;
            smallerList=smallerList.next;
        }

        return -1;
    }


    public static void main(String[] args) {
        //1->2->3->4->5, 6->3->4->5
        Node firstLinkedList=new Node<Integer>(1);
        Node mergePoint = firstLinkedList.next(2).next(3);
        mergePoint.next(4).next(5);

        Node secondLinkedList=new Node<Integer>(6);
        secondLinkedList.next=mergePoint;

        System.out.println(firstLinkedList);
        System.out.println(secondLinkedList);
        System.out.println(mergePointUsingSet(firstLinkedList,secondLinkedList));
        System.out.println(mergePointUsingDelta(firstLinkedList,secondLinkedList));
    }
}
