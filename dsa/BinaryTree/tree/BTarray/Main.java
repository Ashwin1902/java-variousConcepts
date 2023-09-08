package BTarray;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree(5);
        System.out.println(bt.isFull());
       bt.Insert("N1");
        bt.Insert("N2");
        bt.Insert("N3");
        bt.Insert("N4");
        bt.Insert("N5");
        bt.Insert("N6");
 //     bt.preOrder(0);
        bt.preOrder(1);
        //bt.preOrder(3);
        bt.postOrder(1);
        bt.inOrder(1);
        bt.levelOrder();
        bt.search("N3");
        bt.deleteNode("N3");
        bt.levelOrder();
        bt.deleteBt(); 

    }
}
