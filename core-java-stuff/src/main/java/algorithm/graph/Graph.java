package algorithm.graph;
import java.util.*;

public class Graph {
    public Map<Integer, Node> nodeLookUp = new HashMap<>();

    public void addNode(Node node){
        if(!nodeLookUp.containsKey(node.value)){
            nodeLookUp.put(node.value, node);
        }
    }

    public Node getNode(int x){
        if(nodeLookUp.containsKey(x)){
            return nodeLookUp.get(x);
        }else{
            Node node=new Node(x);
            nodeLookUp.put(x, node);
            return node;
        }
    }

    public void addEdge(int x, int y, boolean directed){
        Node nodeX=getNode(x);
        Node nodeY=getNode(y);

        nodeX.adjacent.add(nodeY);

        if(!directed){
            addEdge(y,x,true);
        }
    }


    public boolean hasPathBFS(Node s, Node d){
        Set<Integer> visited=new HashSet<Integer>();
        return hasPathBFS(s,d,visited);
    }


    private boolean hasPathBFS(Node s, Node d, Set<Integer> visited){
        LinkedList<Node> nextToVisit=new LinkedList<>();
        nextToVisit.add(s);

        while(!nextToVisit.isEmpty()){
            Node next=nextToVisit.remove();
            if(visited.contains(next.value)){
                continue;
            }
            visited.add(next.value);
            if(next.value == d.value){
                return true;
            }


            nextToVisit.addAll(next.adjacent);

        }

        return false;
    }
}
