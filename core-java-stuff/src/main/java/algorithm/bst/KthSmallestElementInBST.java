package algorithm.bst;

public class KthSmallestElementInBST {

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


    static void kthSmallestElement(Node node, int smallestIndex){
        if(node == null || count>=smallestIndex) {return; }

        kthSmallestElement(node.left, smallestIndex);
        count++;
        if(count == smallestIndex) {
            System.out.println(smallestIndex+"(st/nd/th) smallest Element is ===>   "+ node.value);
            return;
        }

        kthSmallestElement(node.right, smallestIndex);
    }


    public static void main(String[] args) {
        Node head=new Node(500);
        head.left=new Node(250);
        head.right=new Node(1000);
        head.left.right=new Node(400);
        kthSmallestElement(head, 4);
    }
}
