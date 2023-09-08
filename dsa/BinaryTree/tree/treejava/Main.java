package treejava;

public class Main {
    public static void main(String[] args) {
    TreeNode drinks=new TreeNode("Drinks");
    TreeNode hot=new TreeNode("Hot");
    TreeNode cold=new TreeNode("Cold");
    TreeNode Tea=new TreeNode("Tea");
    TreeNode Coffee=new TreeNode("Coffee");
    TreeNode Soda=new TreeNode("Soda");

    drinks.addChild(hot);
    drinks.addChild(cold);
    hot.addChild(Tea);
    hot.addChild(Coffee);
    cold.addChild(Soda);

    System.out.println(drinks.print(0));
    System.out.println(hot.print(0));
    System.out.println(cold.print(0));

}
}
