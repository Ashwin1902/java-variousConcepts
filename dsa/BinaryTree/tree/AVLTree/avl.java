package AVLTree;
import java.util.*;
public class avl {
	BinaryNode root;

	// Constructor
	avl() {
		root = null;
	}

  // PreOrder Traversal
  public void preOrder(BinaryNode node) {
   if (node == null) {
     return;
   }
   System.out.print(node.value + " ");
   preOrder(node.left);
   preOrder(node.right);
 }

 // Inorder Traversal
 public void inOrder(BinaryNode node) {
   if (node == null) {
     return;
   }
   inOrder(node.left);
   System.out.print(node.value + " ");
   inOrder(node.right);


 }

 // PostOrder Traversal
 public void postOrder(BinaryNode node) {
   if (node == null) {
     return;
   }
   postOrder(node.left);
   postOrder(node.right);
   System.out.print(node.value + " ");
 }

 // Level Order

 void levelOrder() {
   Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
   queue.add(root);
   while (!queue.isEmpty()) {
     BinaryNode presentNode = queue.remove();
     System.out.print(presentNode.value + " ");
     if (presentNode.left != null) {
       queue.add(presentNode.left);
     }
     if (presentNode.right != null) {
       queue.add(presentNode.right);
     }
   }
 }

 public int getHeight(BinaryNode node){
    if(node==null) return 0;
    return node.height;
 }

 private BinaryNode rotateRight(BinaryNode disbalancedNode){
    BinaryNode newRoot= disbalancedNode.left;
    disbalancedNode.left=newRoot.right;
    newRoot.right=disbalancedNode;
    disbalancedNode.height=1+Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height=1+Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
 }
private BinaryNode rotateLeft(BinaryNode disbalancedNode){
    BinaryNode newRoot= disbalancedNode.right;
    disbalancedNode.right=newRoot.left;
    newRoot.left=disbalancedNode;
    disbalancedNode.height=1+Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
    newRoot.height=1+Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
    return newRoot;
 }

 public int getBalance(BinaryNode node){
    if(node==null) return 0;
    else{
        return getHeight(node.left)-getHeight(node.right);
    }
 }
 private BinaryNode insertNode(BinaryNode node,int val){
    if(node==null){
        BinaryNode newNode=new BinaryNode();
        newNode.value=val;
        newNode.height=1;
        return newNode;
    }
    else if(val<node.value){
        node.left=insertNode(node.left, val);
    }
    else{
        node.right=insertNode(node.right, val);
    }
    node.height=1+Math.max(getHeight(node.left), getHeight(node.right));
    int balance=getBalance(node);
    
    if(balance>1 && val<node.left.value){
        return rotateRight(node);
    }
    if(balance>1 && val>node.left.value){
        node.left=rotateLeft(node.left);
        return rotateRight(node);
    }
    if(balance<-1 && val>node.right.value){
        return rotateLeft(node);
    }
    if(balance<-1 && val<node.right.value){
        node.right=rotateRight(node.right);
        return rotateLeft(node);
    }
    return node;
 }

 public void insert(int val){
    root=insertNode(root, val);
 }

 //getMinimum
 public static BinaryNode minNode(BinaryNode root){
     if(root.left==null) return root;
     else return minNode(root.left); 
 }

 //deletion
 private BinaryNode deleteNode(BinaryNode node, int val){
    if (node == null) {
        System.out.println("Value not found in AVL");
        return node;
      }
      if (val < node.value) {
        node.left = deleteNode(node.left, val);
      } else if (val > node.value) {
        node.right = deleteNode(node.right, val);
      } else {
        if (node.left != null && node.right != null) {
          BinaryNode temp = node;
          BinaryNode minNodeForRight = minNode(temp.right);
          node.value = minNodeForRight.value;
          node.right = deleteNode(node.right, minNodeForRight.value);
        } else if (node.left != null) {
          node = node.left;
        } else if (node.right != null) {
          node = node.right;
        } else {
          node = null;
        }
      }
      // Case 2 - rotation required
   
      // System.out.println("1");
      // System.out.println(previous.value);
   
      // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
      int balance = getBalance(node);
   
      if (balance > 1 && getBalance(node.left) >= 0) {
        return rotateRight(node);
      }
      if (balance > 1 && getBalance(node.left) < 0) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
      }
      if (balance < -1 && getBalance(node.right) <= 0) {
        return rotateLeft(node);
      }
   
      if (balance < -1 && getBalance(node.right) > 0) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
      }
   
      return node;
   
    }
   
    public void delete(int value) {
      root = deleteNode(root, value);
    }
   
    public void deleteAVL() {
      root = null;
    }
   
 }



