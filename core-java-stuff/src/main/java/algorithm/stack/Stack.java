package algorithm.stack;

public class Stack<T> {
    private static class Node<T>{
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> top;

    public T pop(){
        if(top ==null){
            return null;
        }
        T data=top.data;
        top = top.next;

        return data;
    }

    public void push(T data){
        Node<T> node=new Node<>(data);
        node.next=top;
        top=node;
    }

    public boolean isEmpty(){
        return top==null;
    }


    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        stack.push('{');
        stack.push('a');
        stack.push('+');
        stack.push('b');
        stack.push('}');

        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
    }

}
