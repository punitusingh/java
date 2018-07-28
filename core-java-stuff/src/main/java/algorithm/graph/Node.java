package algorithm.graph;
import java.util.List;
import java.util.LinkedList;

public class Node {
    public int value;
    public List<Node> adjacent=new LinkedList<Node>();
    public boolean visited;
    public int distance;

    public Node(int value) {
        this.value = value;
    }
}
