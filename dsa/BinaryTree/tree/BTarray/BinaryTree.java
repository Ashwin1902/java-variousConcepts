package BTarray;

public class BinaryTree {
    String[] arr;
    int lastusedIndex;


    //Creation
    public BinaryTree(int size){
        arr=new String[size+1];
        this.lastusedIndex=0;
        System.out.println("Array Created");
    }

    //isFull
    boolean isFull(){
        if(arr.length-1==lastusedIndex){
            return true;
        }
        else return false;
    }

    //insert
    void Insert(String value){
        if(!isFull()){
            arr[lastusedIndex+1]=value;
            lastusedIndex++;
            System.out.println("Inserted");
        }
        else System.out.println("Tree is Full");
    }

    //preOrder traversal
    void preOrder(int index){
        if(index>lastusedIndex || index==0){
            return;
        }
        System.out.println(arr[index]+" ");
        preOrder(index*2);
        preOrder((index*2)+1);
    }
//In order traversal
     void inOrder(int index){
        if(index>lastusedIndex || index==0){
            return;
        }
        preOrder(index*2);
        System.out.println(arr[index]+" ");
        preOrder((index*2)+1);
    }

    //post order traversal
     void postOrder(int index){
        if(index>lastusedIndex || index==0){
            return;
        }
        preOrder(index*2);
        preOrder((index*2)+1);
        System.out.println(arr[index]+" ");
    }

     //level order traversal
    void levelOrder(){
      for(int i=1;i<=lastusedIndex;i++){
        System.out.println(arr[i]+" ");
       }
    }

    //search
     
    int search(String value){
      for(int i=1;i<=lastusedIndex;i++){
        if(arr[i]==value){
        System.out.println(value+" exists at "+i);
        return i;
        }
       }
       System.out.println("value not found");
       return -1;
    }

    //delete
    public void deleteNode(String val){
       int location=search(val);
       if(location==-1){
        return;
       }
       else{
        arr[location]=arr[lastusedIndex];
        lastusedIndex--;
        System.out.println("Successfully deleted the node");
       }
    }

    //delete the bt
    public void deleteBt(){
        try{
            arr=null;
            System.out.println("BT deleted");
        }
        catch(Exception e){
            System.out.println("There was an error");
        }
    } 



}
