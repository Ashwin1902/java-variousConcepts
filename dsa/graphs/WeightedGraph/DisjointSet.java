package WeightedGraph;
import java.util.*;
public class DisjointSet {
    private ArrayList<WeightedNode> nodeList=new ArrayList<>();

    public static void makeSet(ArrayList<WeightedNode> nodeList){
        for(WeightedNode node: nodeList){
            DisjointSet set=new DisjointSet();
            set.nodeList.add(node);
            node.set=set;
        }
    }

    public static DisjointSet findSet(WeightedNode node){
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1,WeightedNode node2){
        if(node1.set.equals(node2.set)){
            return null;
        }
        else{
            DisjointSet set1=node1.set;
            DisjointSet set2=node2.set;
           
            if(set1.nodeList.size()>set2.nodeList.size()){
                ArrayList<WeightedNode> nodeSet2=set2.nodeList;
                for(WeightedNode node: nodeSet2){
                    set1.nodeList.add(node);
                    node.set=set1;
                }
                return set1;
            }
            else{
                ArrayList<WeightedNode> nodeSet1=set1.nodeList;
                for(WeightedNode node: nodeSet1){
                    set2.nodeList.add(node);
                    node.set=set2;
                }
                return set2;
            }
        }
    }

    public void printAllNodesOfThisSet(){
        System.out.println("Printing all nodes of this set: ");
        for(WeightedNode node: nodeList){
            System.out.print(node+" ");
        }
        System.out.println();
    }
    
}
