package algorithm.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents {

    public static Graph buildGraph(){
        Graph graph=new Graph();

        graph.addEdge(0,1, false);
        graph.addEdge(1,2, false);
        graph.addEdge(2,5, false);

        graph.addEdge(3,4, false);

        return graph;

    }


    public static void printGraph(Graph graph){
        for(Map.Entry<Integer, Node> entry:graph.nodeLookUp.entrySet()){
            if(!entry.getValue().visited){
                visit(entry.getValue());
                System.out.println();
            }
        }
    }


    public static void visit(Node node){
        node.visited=true;
        System.out.printf("%d ", node.value);

        for(Node next: node.adjacent){
            if(!next.visited){
                visit(next);
            }
        }

    }


    public static void main(String[] args) {
        Graph graph=buildGraph();
        printGraph(graph);
    }
}
