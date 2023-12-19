package WeightedGraph;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList=new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
         nodeList.add(new WeightedNode("E", 4));
        // nodeList.add(new WeightedNode("F", 5));
        // nodeList.add(new WeightedNode("G", 6));

        // FloydWarshall g=new FloydWarshall(nodeList);
        // g.addWeightedEdge(0, 3, 1);
        // g.addWeightedEdge(0, 1, 8);
        // g.addWeightedEdge(1, 2, 1);
        // g.addWeightedEdge(2, 0, 4);
        // g.addWeightedEdge(3, 1, 2);
        // g.addWeightedEdge(3, 2, 9);
        // g.addWeightedEdge(2, 4, 4);
        // g.addWeightedEdge(4, 6, 9);
        // g.addWeightedEdge(5, 6, 7);

       // g.floydWarshall();
        
       // System.out.println("Printing bellman ford from index 0: ");
        //g.bellmanford(nodeList.get(0));


        // DisjointSet.makeSet(nodeList);
        // WeightedNode firstNode=nodeList.get(0);
        // WeightedNode secondNode=nodeList.get(1);
        // DisjointSet output= DisjointSet.findSet(secondNode);
        // output.printAllNodesOfThisSet();

        // DisjointSet.union(firstNode, secondNode);
        // output= DisjointSet.findSet(secondNode);
        // output.printAllNodesOfThisSet();

       // Kruskal graph=new Kruskal(nodeList);
               prims graph=new prims(nodeList);

        graph.addUndirectedEdge(0, 1, 5);
        graph.addUndirectedEdge(0, 2, 13);
        graph.addUndirectedEdge(0, 4, 15);
        graph.addUndirectedEdge(1, 2, 10);
        graph.addUndirectedEdge(1, 3, 8);
        graph.addUndirectedEdge(2, 3, 6);
        graph.addUndirectedEdge(2, 4, 20);
        graph.primsAlgo(nodeList.get(4));

    }
}
