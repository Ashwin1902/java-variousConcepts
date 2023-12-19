package WeightedGraph;

import java.util.*;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

  public WeightedGraph(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void dijkstra(WeightedNode node){
    PriorityQueue<WeightedNode> queue=new PriorityQueue<>();
    node.distance=0;
    queue.addAll(nodeList);
    while(!queue.isEmpty()){
        WeightedNode currentNode=queue.remove();
        for(WeightedNode neighbour: currentNode.neighbours){
            if(queue.contains(neighbour)){
                if(neighbour.distance> currentNode.distance+currentNode.weightMap.get(neighbour)){
                    neighbour.distance= currentNode.distance+currentNode.weightMap.get(neighbour);
                    neighbour.parent=currentNode;
                    queue.remove(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }
    for (WeightedNode nodeToCheck : nodeList) {
        System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
        pathPrint(nodeToCheck);
        System.out.println();
      }
  }

  public static void pathPrint(WeightedNode node) {
    if (node.parent  != null) {
      pathPrint(node.parent);
    }
    System.out.print(node.name + " ");
  }

  public void addWeightedEdge(int i,int j,int d){
    WeightedNode first=nodeList.get(i);
    WeightedNode second=nodeList.get(j);
    first.neighbours.add(second);
    first.weightMap.put(second, d);
  }

  //------------------------------
  public void bellmanford(WeightedNode node){
    node.distance=0;
        for(int i=0;i<nodeList.size();i++){
            for(WeightedNode currentNode:nodeList){
              for(WeightedNode neighbour:currentNode.neighbours)
                if(neighbour.distance> currentNode.distance+currentNode.weightMap.get(neighbour)){
                    neighbour.distance= currentNode.distance+currentNode.weightMap.get(neighbour);
                    neighbour.parent=currentNode;
                }
            }
    }
    System.out.println("Checking for negative cycle...");
    for(WeightedNode currentNode:nodeList){
              for(WeightedNode neighbour:currentNode.neighbours)
                if(neighbour.distance> currentNode.distance+currentNode.weightMap.get(neighbour)){
                    System.out.println("Negative cycle detected");
                    System.out.println("Vertex name: "+neighbour.name);
                    System.out.println("old distance: "+neighbour.distance);
                    int a=currentNode.distance+currentNode.weightMap.get(neighbour);
                    System.out.println("New distamce: "+a);
                    return;
                }
            }
    System.out.println("Negative cycle not found");
    for (WeightedNode nodeToCheck : nodeList) {
        System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
        pathPrint(nodeToCheck);
        System.out.println();
      }
  }
  //-----------------------------------
}
