package algorithm.linkedlist;

public class MergeSortedLinkedList {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
        }

        @Override
        public String toString() {
            return ""+value;
        }
    }


    static void print(Node node){
        while(node != null){
            System.out.print("\t"+node);
            node = node.next;
        }
        System.out.println();
    }


    static Node merge(Node a, Node b){
        Node dummy=new Node(0);
        Node temp=dummy;

        while(a!=null || b!=null){
            if(a==null){
                temp.next=b;
                return dummy.next;
            }


            if(b==null){
                temp.next=a;
                return dummy.next;
            }

            if(a.value < b.value){
                temp.next=a;
                a=a.next;

            }else{
                temp.next=b;
                b=b.next;
            }

            temp = temp.next;
            temp.next=null;
        }


        return dummy.next;
    }

    public static void main(String[] args) {



        Node a=new Node(5);
        a.next=new Node(10);
        a.next.next=new Node(15);


        Node b=new Node(2);
        b.next=new Node(3);
        b.next.next=new Node(20);

        Node mergedHead=merge(a,b);

        print(mergedHead);


        print(b);

        print(a);

    }
}

