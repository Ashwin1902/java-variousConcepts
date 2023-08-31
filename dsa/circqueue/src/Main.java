public class Main {
    public static void main(String[] args) {
        CircularQueue cq=new CircularQueue(5);
        System.out.println(cq.isempty());
        System.out.println(cq.isfull());
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        System.out.println(cq.isempty());
        System.out.println(cq.isfull());
     //   cq.enqueue(5);
        cq.enqueue(6);
        System.out.println(cq.isfull());
        cq.dequeue();
        cq.dequeue();
        System.out.println(cq.isempty());
        System.out.println(cq.isfull());
        cq.enqueue(10);
        cq.enqueue(11);





    }
    
}
