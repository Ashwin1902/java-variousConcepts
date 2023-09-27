public class Main{
    public static void main(String[] args) {
        BinaryHeap heap1=new BinaryHeap(5);
        heap1.insert(2, "Min");
        heap1.insert(3, "Min");
        heap1.insert(9, "Min");
        heap1.insert(1, "Min");
        heap1.insert(7, "Min");
        heap1.levelorder();
        heap1.extracthead("Min");
        heap1.levelorder();
        heap1.deleteHeap();

    }
}