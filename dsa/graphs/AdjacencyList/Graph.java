package AdjacencyList;
import java.util.*;
public class Graph {
   public ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
   
   public Graph(ArrayList<GraphNode> nodeList){
    this.nodeList=nodeList;
   }

   public void addUnidirectedEdge(int i,int j){
    GraphNode first=nodeList.get(i);
    GraphNode second=nodeList.get(j);
    first.neighbours.add(second);
    second.neighbours.add(first);
}

public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j =0; j < nodeList.get(i).neighbours.size(); j++) {
        if (j == nodeList.get(i).neighbours.size()-1 ) {
          s.append((nodeList.get(i).neighbours.get(j).name) );
        } else {
          s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
        }
      }
      s.append("\n");
    }
    return s.toString();
  }

  //bfs
  void bfsVisit(GraphNode node){
    LinkedList<GraphNode> queue=new LinkedList<GraphNode>();
    queue.add(node);
    while(!queue.isEmpty()){
      GraphNode currentNode=queue.remove(0);
      currentNode.isVisited=true;
      System.out.print(currentNode.name+" ");
      for(GraphNode g: currentNode.neighbours){
        if(!g.isVisited){
          queue.add(g);
          g.isVisited=true;
        }
      }
    }
  }

  public void bfs(){
    for(GraphNode g: nodeList){
      if(!g.isVisited) bfsVisit(g);
    }
  }


  //dfs
  void dfsVisit(GraphNode node){
    Stack<GraphNode> st=new Stack<>();
    st.push(node);
    while(!st.isEmpty()){
      GraphNode currentNode=st.pop();
      currentNode.isVisited=true;
      System.out.print(currentNode.name+" ");
      for(GraphNode g: currentNode.neighbours){
        if(!g.isVisited){
          st.push(g);
          g.isVisited=true;
        }
      }
    }
  }

  public void dfs(){
    for(GraphNode g: nodeList){
      if(!g.isVisited) dfsVisit(g);
    }
  }

  public void addDirectedEdge(int i,int j){
    GraphNode first=nodeList.get(i);
    GraphNode second=nodeList.get(j);
    first.neighbours.add(second);
  }

  void topologicalVisit(GraphNode node,Stack<GraphNode> stack){
    for(GraphNode neighbour:node.neighbours){
      if(!neighbour.isVisited){
        topologicalVisit(neighbour, stack);
      }
    }
    node.isVisited=true;
    stack.push(node);
  }

  void topologicalSort(){
    Stack<GraphNode> stack=new Stack<>();
    for(GraphNode node:nodeList){
      if(!node.isVisited){
        topologicalVisit(node,stack);
      }
    }
    while(!stack.isEmpty()){
      System.out.print(stack.pop().name+" ");
    }
  }

  void pathPrint(GraphNode node){
    if(node.parent!=null){
      pathPrint(node.parent);
    }
    System.out.print(node.name+" ");
  }

  void BFSforSSSPP(GraphNode node){
    LinkedList<GraphNode> queue=new LinkedList<GraphNode>();
    queue.add(node);
    while(!queue.isEmpty()){
      GraphNode currentNode=queue.remove(0);
      currentNode.isVisited=true;
      System.out.print("Printng path for Node "+currentNode.name+": ");
      pathPrint(currentNode);
      System.out.println();
      for(GraphNode g: currentNode.neighbours){
        if(!g.isVisited){
          queue.add(g);
          g.isVisited=true;
          g.parent=currentNode;
        }
      }
    }
  }






}
