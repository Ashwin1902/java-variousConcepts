package binarytreeLL;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
    
    //creation
    BinaryNode root;
    public BinaryTreeLL(){
        this.root=null;
    }

    //Traversal
    // 1) pre order traversal

    void preOrder(BinaryNode node){
        if(node==null) return;
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // 2) Inorder traversal

    void InOrder(BinaryNode node){
        if(node==null) return;
        preOrder(node.left);
        System.out.println(node.value+" ");
        preOrder(node.right);
    }

    // 3) PostOrder traversal

    void postOrder(BinaryNode node){
        if(node==null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.value+" ");
    }

    // 4) levelOrder traversal

    void levelOrder(){
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode pn=q.remove();
            System.out.println(pn.value+" ");
            if(pn.left!=null) q.add(pn.left);
            if(pn.right!=null) q.add(pn.right);
        }
    }

    //search
    public void search(String value){
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode pn=q.remove();
            if(pn.value.equals(value)){
                System.out.println("val found");
                return;
            }
            else{
                if(pn.left!=null) q.add(pn.left);
                if(pn.right!=null) q.add(pn.right);
            }
        }
        System.out.println("Value not found");
    }

    //insertion
    public void insert(String val){
        BinaryNode newNode=new BinaryNode();
        newNode.value=val;
        if(root==null){
            root=newNode;
            System.out.println("Inserted");
            return;
        }
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode pn=q.remove();
            if(pn.left==null){
                pn.left=newNode;
                System.out.println("Inserted");
                break;
            }
            else if(pn.right==null){
                pn.right=newNode;
                System.out.println("Inserted");
                break;
            }
            else{
              q.add(pn.left);
              q.add(pn.right);
            }
        }
    }

    //deletion
     //get deepest node
     public BinaryNode getDeepestNode(){
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        BinaryNode pn=null;
        while(!q.isEmpty()){
            pn=q.remove();
            if(pn.left!=null){
                q.add(pn.left);
            }
            if(pn.right!=null){
                q.add(pn.right);
            }
        }
        return pn;
     }

     //delete deepest node
     public void deleteDeepestNode(){
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        BinaryNode pren=null;
        BinaryNode pn=null;
        while(!q.isEmpty()){
            pren=pn;
            pn=q.remove();
            if(pn.left==null){
                pren.right=null;
                return;
            }
            else if(pn.right==null){
                pn.left=null;
                return;
            }
            q.add(pn.left);
            q.add(pn.right);
        }
     }

     //delete given node
     void deleteNode(String value){
        Queue<BinaryNode> q=new LinkedList<BinaryNode>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryNode pn=q.remove();
            if(pn.value==value){
                pn.value=getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("Node is deleted");
                return;
            }
            else{
                if(pn.left!=null){
                    q.add(pn.left);
                }
                if(pn.right!=null){
                    q.add(pn.right);
                }
            }
        }
        System.out.println("Node Not Found");
     }

    //delete a tree
    void deleteBT(){
        root=null;
        System.out.println("Deleted the BT");
    }
}
