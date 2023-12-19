package AdjacencyMatrix;
import java.util.*;

public class Graph {
    public ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
    public int[][] adjacencyMatrix; 
 
    public Graph(ArrayList<GraphNode> nodeList){
        this.nodeList=nodeList;
        adjacencyMatrix=new int[nodeList.size()][nodeList.size()];
    }

    public void addUnidirectedEdge(int i,int j){
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
          s.append(nodeList.get(i).name + ": ");
          for (int j : adjacencyMatrix[i]) {
            s.append((j) + " ");
          }
          s.append("\n");
        }
        return s.toString();
      }


      //get neighbours
    ArrayList<GraphNode> neighbours(GraphNode node){
      int currentIndex=node.index;
      ArrayList<GraphNode> neighbours=new ArrayList<GraphNode>();
      for(int i=0;i<adjacencyMatrix.length;i++){
         if(adjacencyMatrix[currentIndex][i]==1){
           neighbours.add(nodeList.get(i));
          }
      }
      return neighbours;
    }

    //bfs 
    void bfsVisit(GraphNode node){
      LinkedList<GraphNode> queue=new LinkedList<GraphNode>();
      queue.add(node);
      while(!queue.isEmpty()){
        GraphNode currentNode=queue.remove(0);
        currentNode.isVisited=true;
        System.out.print(currentNode.name+" ");
        ArrayList<GraphNode> neighbours=neighbours(currentNode);
        for(GraphNode g: neighbours){
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

    void dfsVisit(GraphNode node){
      Stack<GraphNode> s=new Stack<>();
      s.push(node);
      while(!s.isEmpty()){
        GraphNode currentNode=s.pop();
        currentNode.isVisited=true;
        System.out.print(currentNode.name+" ");
        ArrayList<GraphNode> neighbours=neighbours(currentNode);
        for(GraphNode g: neighbours){
          if(!g.isVisited){
            s.push(g);
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
        adjacencyMatrix[i][j]=1;
    }

    void topologicalVisit(GraphNode node,Stack<GraphNode> stack){
      ArrayList<GraphNode> neighbours=neighbours(node);
      for(GraphNode neighbour:neighbours){
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
        System.out.print("Shortest path for "+currentNode.name+" :");
        pathPrint(currentNode);
        System.out.println();
        ArrayList<GraphNode> neighbours=neighbours(currentNode);
        for(GraphNode g: neighbours){
          if(!g.isVisited){
            queue.add(g);
            g.isVisited=true;
            g.parent=currentNode;
          }
        }
      }
    }



}
