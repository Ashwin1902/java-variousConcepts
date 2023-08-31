public class CircularQueue{
    int[] arr;
    int topofqueue;
    int beginningofqueue;
    int size;

    //creation
    public CircularQueue(int size){
        this.arr=new int[size];
        this.size=size;
        this.topofqueue=-1;
        this.beginningofqueue=-1;
        System.out.println("Queue Created");
    }

    //isempty
    public boolean isempty(){
        if(topofqueue==-1){
            return true;
        }
        else return false;
    }

    //isfull
    public boolean isfull(){
        if(topofqueue+1==beginningofqueue) return true;
        else if(beginningofqueue==0 && topofqueue+1==size) return true;
        else return false;
    }

    //enqueue
    public void enqueue(int value){
        if(isfull()) System.out.println("Queue is full");
        else if(isempty()){
            beginningofqueue=0;
            topofqueue++;
            arr[topofqueue]=value;
            System.out.println("Inserted");
        }
        else{
            if(topofqueue+1==size) topofqueue=0;
            else topofqueue++;
        }
        arr[topofqueue]=value;
        System.out.println("Inserted");
    }

    //dequeue
    public int dequeue(){
        if(isempty()){
            System.out.println("empty");
            return -1;
        }
        else{
            int result=arr[beginningofqueue];
            arr[beginningofqueue]=0;
            if(beginningofqueue==topofqueue) beginningofqueue=topofqueue=-1;
            else if(beginningofqueue+1==size) beginningofqueue=0;
            else beginningofqueue++;
            return result;
        }
    }
    //peek--> same as linear queue

    //delete queue
    public void deletequeue(){
        arr=null;
        System.out.println("Deleted the queue");
    }
    
}