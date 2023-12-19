package WeightedGraph;
import java.util.*;
public class Kruskal {
    ArrayList<WeightedNode> nodeList=new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList=new ArrayList<>();
    
    public Kruskal(ArrayList<WeightedNode> nodeList){
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

    void kruskal(){
        DisjointSet.makeSet(nodeList);
        Comparator<UndirectedEdge> comparator=new  Comparator<UndirectedEdge>(){
            @Override
            public int compare(UndirectedEdge o1,UndirectedEdge o2){
                return o1.weight-o2.weight;
            }
        };
        Collections.sort(edgeList,comparator);
        int cost=0;
        for(UndirectedEdge edge: edgeList){
            WeightedNode first=edge.first;
            WeightedNode second=edge.second;
            if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.union(first, second);
                cost+=edge.weight;
                System.out.println("Taken: "+edge);
            }
        }
        System.out.println("Total cost of MST "+cost);
    }
}
