package AVLTree;

public class Main {
    public static void main(String[] args) {
        avl tree1=new avl();
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(4);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(7);
        tree1.insert(10);
        tree1.insert(5);

        tree1.levelOrder();

        tree1.delete(6);
        System.out.println();
        tree1.levelOrder();

        tree1.deleteAVL();

    }
    
}
