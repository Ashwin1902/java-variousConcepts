
public class Main {
    public static void main(String[] args){
        queuearray q=new queuearray(5);
        System.out.println(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(2);
        q.enqueue(2);
        q.enqueue(2);
        System.out.println(q);
        System.out.println(q.isFull());
        //int a=q.peek();
        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.deletequeue();





    }
}
