package algorithm.linkedlist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HackerRankFindMergePoint {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static int getLength(SinglyLinkedListNode head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }

        return i;
    }

    static SinglyLinkedListNode getSmallerList(int lengthOfFirstLinkedList, int lengthOfSecondLinkedList, SinglyLinkedListNode head1, SinglyLinkedListNode head2){
        return lengthOfFirstLinkedList>lengthOfSecondLinkedList? head2 : head1;
    }

    static SinglyLinkedListNode getLargerList(int lengthOfFirstLinkedList, int lengthOfSecondLinkedList, SinglyLinkedListNode head1, SinglyLinkedListNode head2){
        return lengthOfFirstLinkedList>lengthOfSecondLinkedList? head1 : head2;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int lengthOfFirstLinkedList=getLength(head1);
        System.out.println("lengthOfFirstLinkedList===>"+lengthOfFirstLinkedList);
        int lengthOfSecondLinkedList=getLength(head2);
        System.out.println("lengthOfSecondLinkedList===>"+lengthOfSecondLinkedList);

        int delta=Math.abs(lengthOfFirstLinkedList-lengthOfSecondLinkedList);

        SinglyLinkedListNode smallerList=getSmallerList(lengthOfFirstLinkedList,lengthOfSecondLinkedList, head1, head2);
        SinglyLinkedListNode largerList=getLargerList(lengthOfFirstLinkedList,lengthOfSecondLinkedList, head1, head2);;
        while (delta>0){
            largerList=largerList.next;
            delta--;
        }

        while (largerList!=null && smallerList!=null){
            if(largerList.data == smallerList.data){
                return largerList.data;
            }

            largerList=largerList.next;
            smallerList=smallerList.next;
        }

        return -1;

    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }



    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist1 = new SinglyLinkedList();

        SinglyLinkedList llist2 = new SinglyLinkedList();

        llist1.insertNode(1);
        llist1.insertNode(2);
        llist1.insertNode(3);
        llist1.insertNode(4);


        llist2.insertNode(4);

        System.out.println(findMergeNode(llist1.head,llist2.head));
    }
}