package algorithm.bst;


public class BinarySearchTree {


    private Node root;
    private int counter;

    BinarySearchTree(){
        this.root=null;
        this.counter=0;
    }

   private void insert(int value){
        if(this.root == null){
            this.root=new Node(value);
            return;
        }

        this.insert(this.root,value);
    }

    private void insert(Node node,int value){
        this.counter +=1;
        if(value <= node.value){
            if(node.left == null){
                node.left=new Node(value);
            }else{
                this.insert(node.left,value);
            }
        }else{
            if(node.right == null){
                node.right=new Node(value);
            }else{
                this.insert(node.right,value);
            }

        }
    }

    private void insertAll(int[] items){
         for (int item : items) {
             this.insert(item);
             System.out.println(this.counter);
         }
    }

    private static void insertAllIterative(int[] items){
        Node root=new Node(items[0]);

        long counter=0;

        int length=items.length;
        for (int i=1;i<length;i++) {
            System.out.println(counter);
            int value=items[i];
            Node currentNode=root;
            Node parentNode=currentNode;

            while(currentNode!=null){
                parentNode=currentNode;
                if(value <= currentNode.value){
                    currentNode = currentNode.left;
                }else{
                    currentNode = currentNode.right;
                }
                if(currentNode!=null){
                    counter++;
                }
            }

            if(value <= parentNode.value){
                parentNode.left=new Node(value);
                counter++;
            }else{
                parentNode.right=new Node(value);
                counter++;
            }
        }

        System.out.println(counter);
    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr=new int[n];
//        int i=0;
//
//        if(n<0 || n>300001){
//            return;
//        }
//
//        while(i < n){
//            arr[i] = sc.nextInt();
//            i++;
//        }
//
//        BinarySearchTree.insertAllIterative(arr);
        BinarySearchTree.insertAllIterative(new int[]{3,5,1,6,8,7,2,4});
    }


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
}
