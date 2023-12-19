package WeightedGraph;
import java.util.*;
public class prims {
    ArrayList<WeightedNode> nodeList=new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList=new ArrayList<>();
    
    public prims(ArrayList<WeightedNode> nodeList){
        this.nodeList=nodeList;
    }

    public void addUndirectedEdge(int firstindex,int secondindex,int weight){
        UndirectedEdge edge=new UndirectedEdge(nodeList.get(firstindex), nodeList.get(secondindex), weight);
        WeightedNode first=edge.first;
        WeightedNode second=edge.second;
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    void primsAlgo(WeightedNode node){
    for(int i=0;i<nodeList.size();i++){
        nodeList.get(i).distance=Integer.MAX_VALUE;
    }
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
    int cost=0;
    for(WeightedNode nodetocheck:nodeList){
        System.out.println("Node: "+nodetocheck+", key "+nodetocheck.distance+" parent "+nodetocheck.parent);
        cost+=nodetocheck.distance;
    }
    System.out.println("Total cost: "+cost);
}
}
