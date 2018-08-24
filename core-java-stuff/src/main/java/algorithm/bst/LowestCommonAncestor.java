package algorithm.bst;


import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class LowestCommonAncestor {
    /*
        class Node
            int data;
            Node left;
            Node right;
        */
    public static Node lcaStack(Node root, int v1, int v2) {
        // Write your code here.
        Stack<Node> pathToV1=getPathStack(root, v1);
        Stack<Node> pathToV2=getPathStack(root, v2);
        Node lastNode=null;
        while(!pathToV1.isEmpty() && !pathToV2.isEmpty()){
            Node v1Node = pathToV1.pop();
            Node v2Node = pathToV2.pop();

            if(v1Node == v2Node){
                lastNode = v1Node;
            }else{
                break;
            }
        }

        return lastNode;
    }

    public static Stack<Node> getPathStack(Node root, int value){
        if(root.data == value){
            Stack<Node> s = new Stack<Node>();
            s.push(root);
            return s;
        }
        Stack<Node> stack;
        if(value < root.data){
            stack =  getPathStack(root.left, value);
        }else{
            stack = getPathStack(root.right, value);
        }

        stack.push(root);

        return stack;
    }


    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        Deque<Node> pathToV1=getPath(root, v1);
        Deque<Node> pathToV2=getPath(root, v2);
        Node lastNode=null;
        while(!pathToV1.isEmpty() && !pathToV2.isEmpty()){
            Node v1Node = pathToV1.poll();
            Node v2Node = pathToV2.poll();

            if(v1Node == v2Node){
                lastNode = v1Node;
            }else{
                break;
            }
        }

        return lastNode;
    }

    public static Deque<Node> getPath(Node root, int value){
        Deque<Node> queue = new LinkedList<Node>();
        getPath(root, value, queue);
        return queue;
    }

    public static void getPath(Node root, int value, Deque<Node> queue){
        queue.add(root);
        if(root.data == value){
            return ;
        }


        if(value < root.data){
            getPath(root.left, value, queue);
        }else{
            getPath(root.right, value, queue);
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}

