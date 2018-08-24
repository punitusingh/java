package algorithm.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumOfTree {

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


    static List<Integer> sumOfTree(Node root){

        List<Integer> sumList=new ArrayList<>();

        int rootSum=sumOfTree(root, sumList);
        System.out.println("rootSum is====>"+rootSum);
        return sumList;
    }


    static int sumOfTree(Node node, List<Integer> sumList){
        int result = node.data;
        if(node.left!=null){
            result += sumOfTree(node.left, sumList);
        }

        if(node.right!=null){
            result += sumOfTree(node.right, sumList);
        }

        sumList.add(result);

        return result;
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


        System.out.println(sumOfTree(root));

    }
}
