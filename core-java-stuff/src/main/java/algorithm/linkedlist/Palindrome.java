package algorithm.linkedlist;

public class Palindrome {

    static boolean palindrome(Node<Integer> head){
        //doubleSpeed   0   2   4   5
        //singleSpeed   0   1   2

        Node<Integer> doubleSpeed=head;
        Node<Integer> singleSpeed=head;
        int count=0;
        while(doubleSpeed.next!=null){
            if(doubleSpeed.next.next!=null){
                singleSpeed=singleSpeed.next;
                doubleSpeed=doubleSpeed.next.next;
            }else{
                doubleSpeed=doubleSpeed.next;
            }
            count++;
        }

        System.out.println("count is::"+count);
        Node<Integer> tail=reverse(singleSpeed);
        System.out.println("tail is::");
        LinkedListUtil.print(tail);
        System.out.println("head is::");
        LinkedListUtil.print(head);
        while (count>0){
            count--;
            System.out.println("head.value::"+head.value);
            System.out.println("tail.value::"+tail.value);
            if(!head.value.equals(tail.value)){
                return false;
            }

            head=head.next;
            tail=tail.next;
        }


        return true;
    }


    static Node<Integer> reverse(Node<Integer> head){
        //1-->2-->3-->4
        Node<Integer> next=head.next;//2
        Node<Integer> prev=head;//1
        Node<Integer> temp=null;

        prev.next=null;
        while (next!=null){
            temp=next.next;//3

            //swap pointer
            next.next=prev;//1

            //move ahead
            prev=next;
            next=temp;//3
        }

        return  prev;// head=3
    }

    public static void main(String[] args) {
            Node<Integer> head=LinkedListUtil.insertAll(new int[]{0,2,11,15,15,11,2,0});
        System.out.println(palindrome(head));

      //  LinkedListUtil.print(reverse(head));

    }
}
