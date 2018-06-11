package algorithm.linkedlist;

public class SumOfLinkedList {



    static Node<Integer> recSum(Node<Integer> digit1Head,Node<Integer> digit2Head,int carry){
            if(digit1Head==null && digit2Head==null && carry==0){
                return null;
            }

            int sum=carry;
            if(digit1Head!=null){
                sum=sum+digit1Head.value;
            }
            if(digit2Head!=null){
                sum=sum+digit2Head.value;
            }

            carry=sum>10?1:0;

            sum=sum%10;


            Node<Integer> node=new Node<>(sum);

            node.next=recSum(digit1Head!=null?digit1Head.next:null,
                    digit2Head!=null?digit2Head.next:null,carry);

            return node;

    }


    static Node<Integer> sum(Node<Integer> digit1Head,Node<Integer> digit2Head){
        Node<Integer> sumHead=null;
        Node<Integer> nextNode=null;

        Node<Integer> number1=digit1Head;

        Node<Integer> number2=digit2Head;

        int carry=0;

        while(number1!=null && number2!=null){
            int value=number1.value+number2.value+carry;
            if(value > 10){
                value=value-10;
                carry=1;
            }else{
                carry=0;
            }
            Node<Integer> newNode=new Node<>(value);
            if(sumHead==null){
                sumHead=newNode;
                nextNode=sumHead;
            }else{
                nextNode.next=newNode;
                nextNode=newNode;
            }
            number1=number1.next;
            number2=number2.next;
        }

        while(number1!=null){
            Node<Integer> newNode=new Node<>(number1.value);
            nextNode.next=newNode;
            nextNode=newNode;
            number1=number1.next;
        }

        while(number2!=null){
            Node<Integer> newNode=new Node<>(number2.value);
            nextNode.next=newNode;
            nextNode=newNode;
            number2=number2.next;
        }

        return sumHead;
    }

    static int linkedListToNum(Node<Integer> node){
        int sum=0;
        while (node!=null){
            sum=sum*10 + node.value;
            node=node.next;
        }

        return sum;
    }

    static Node<Integer> numberToLinkedList(int sum){
        Node<Integer>  head=new Node<>(sum%10);
        sum=sum/10;
        while(sum!=0){
            Node<Integer>  node=new Node<>(sum%10);
            sum=sum/10;
            node.next=head;
            head=node;
        }

        return head;
    }

    static Node<Integer> sumForward(Node<Integer> digit1Head,Node<Integer> digit2Head){

        int number1=linkedListToNum(digit1Head);
        int number2=linkedListToNum(digit2Head);

        int sum=number1+number2;
        System.out.println("sum is:"+sum);
        return numberToLinkedList(sum);

    }

    public static void main(String[] args) {
        Node<Integer> digit1Head=LinkedListUtil.insertAll(new int[]{7,1,6});
        Node<Integer> digit2Head=LinkedListUtil.insertAll(new int[]{5,9,2});

        LinkedListUtil.print(sum(digit1Head,digit2Head));


        System.out.println("\nrecursive sum");
        LinkedListUtil.print(recSum(digit1Head,digit2Head,0));


        System.out.println("\nforward sum");
        digit1Head=LinkedListUtil.insertAll(new int[]{6,1,7});
        digit2Head=LinkedListUtil.insertAll(new int[]{2,9,5});
        LinkedListUtil.print(sumForward(digit1Head,digit2Head));



    }
}
