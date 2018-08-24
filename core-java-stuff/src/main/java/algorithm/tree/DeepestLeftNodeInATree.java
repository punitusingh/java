package algorithm.tree;

import java.util.Deque;
import java.util.LinkedList;

public class DeepestLeftNodeInATree {

    static class Node
    {
        int data;
        Node left, right;

        // Constructor
        public Node(int data)
        {
            this.data = data;
        }
    }


    static int findDeepestLeftNode(Node root){
        if(root == null) return -1;


        Deque<Node> q=new LinkedList<>();
        q.add(root);

        Node deepest=root;

        while(!q.isEmpty()){
            Node node=q.poll();

            if(node.left!=null){
                q.add(node.left);
                deepest=node.left;
            }

            if(node.right!=null){
                q.add(node.right);
            }
        }

        return deepest.data;

    }

    static int findDeepestNode(Node root){
        if(root == null) return -1;


        Deque<Node> q=new LinkedList<>();
        q.add(root);

        Node deepest=root;

        while(!q.isEmpty()){
            deepest=q.poll();

            if(deepest.left!=null){
                q.add(deepest.left);
            }

            if(deepest.right!=null){
                q.add(deepest.right);
            }
        }

        return deepest.data;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.right.right.right = new Node(10);


        System.out.println(findDeepestLeftNode(root));

        System.out.println(findDeepestNode(root));
    }
}
