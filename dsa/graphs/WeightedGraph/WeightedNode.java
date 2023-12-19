package WeightedGraph;
import java.util.*;

public class WeightedNode implements Comparable<WeightedNode>{
    String name;
    ArrayList<WeightedNode> neighbours=new ArrayList<WeightedNode>();
    HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    boolean isVisited=false;
    WeightedNode parent;
    int distance;
    int index;
    DisjointSet set;

    WeightedNode(String name,int index){
        this.index=index;
        this.name=name;
        distance=Integer.MAX_VALUE;
    }

    @Override
    public String toString(){
        return name;
    }
   @Override
   public int compareTo(WeightedNode o) {
       return this.distance - o.distance;
   }
}
