package algorithm.bst;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
        }
    }


    static void printPaths(Node root){
        printPaths(root, "");
    }


    static void printPaths(Node root, String path){
        if(root == null ) return;

        path=path+root.data+"\t";

        if(root.left==null && root.right==null){
            System.out.println(path);
            return;
        }

        printPaths(root.left, path);
        printPaths(root.right, path);
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printPaths(root);
    }



}
