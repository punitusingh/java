package algorithm.bst;

public class KthLargestElementInBST {

    static int count=0;

    static class Node{
        Node left;
        Node right;
        int value;
        Node(int value){
            this.left=null;
            this.right=null;
            this.value=value;
        }

        @Override
        public String toString() {
            return "{value: "+this.value+", left:"+this.left+", right:"+this.right+"}";
        }
    }


    static void kthLargestElement(Node node, int largestIndex){
        if(node == null || count>=largestIndex) {return; }

        kthLargestElement(node.right, largestIndex);
        count++;
        if(count == largestIndex) {
            System.out.println(largestIndex+"(st/nd/th) largest Element is ===>   "+ node.value);
            return;
        }

        kthLargestElement(node.left, largestIndex);
    }


    public static void main(String[] args) {
        Node head=new Node(500);
        head.left=new Node(250);
        head.right=new Node(1000);
        head.left.right=new Node(400);
        kthLargestElement(head, 1);
    }
}
