package algorithm.graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ShortestReachInGraph {

    private static final Scanner scanner = new Scanner(System.in);


    public static int[] visitInOrder(int start, Graph graph){
        int nodeSize=graph.nodeLookUp.size();
        int[] distance=new int[nodeSize+1];
        Arrays.fill(distance,-1);
       distance[start] = 0;
       LinkedList<Integer> queue=new LinkedList<>();
       queue.add(start);

       while(!queue.isEmpty()){
           int nodeValue=queue.poll();
           for(Node n:graph.getNode(nodeValue).adjacent){
               if(distance[n.value]==-1){
                   distance[n.value] = distance[nodeValue] + 6;
                   queue.add(n.value);
               }
           }
       }

       return distance;
    }


    public static void main(String[] args) throws IOException {

      // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queries = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Graph[] graphs=new Graph[queries];
        int[] starts=new int[queries];
        for(int i=0;i<queries;i++){
            Graph graph=new Graph();
            graphs[i] = graph;
            String[] nm=scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]); //nodes
            for(int node=1;node<=n;node++){
                graph.addNode(new Node(node));
            }
            int m = Integer.parseInt(nm[1]); //edges
            for(int j=0;j<m;j++) {
                //u, v an edge
                String[] uv=scanner.nextLine().split(" ");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                graph.addEdge(u,v,false);
            }

            int start = scanner.nextInt();
            starts[i] = start;
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }


        for(int i=0;i<queries;i++){
            int[] distances=visitInOrder(starts[i],graphs[i]);
            for(int j=1;j<distances.length;j++){
                if(distances[j]!=0){
                    System.out.print(distances[j]+" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
