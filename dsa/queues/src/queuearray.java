public class queuearray {
    int[] arr;
    int topofqueue;
    int beginningofqueue;
   
   //Creation
    public queuearray(int size){
        this.arr=new int[size];
        this.topofqueue=-1;
        this.beginningofqueue=-1;
        System.out.println("Queue created");
    }

    //isFull
    public boolean isFull(){
        if(topofqueue==arr.length-1) return true;
        else return false;
    }
    //isEmpty
    public boolean isEmpty(){
        if(beginningofqueue==-1 || beginningofqueue==arr.length-1) return true;
        else return false;
    }

    //enqueue
    public void enqueue(int value){
        if(isFull()) System.out.println("Queue is full");
        else if(isEmpty()){
            beginningofqueue=0;
            topofqueue++;
            arr[topofqueue]=value;
            System.out.println("Inserted");
        }
        else{
            topofqueue++;
            arr[topofqueue]=value;
            System.out.println("Inserted");
        }
    }
    //dequeue
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int res=arr[beginningofqueue];
            beginningofqueue++;
            if(beginningofqueue>topofqueue) beginningofqueue=topofqueue-1;
            return res;
        }
    }
    //peek
    public int peek(){
        if(!isEmpty()) return arr[beginningofqueue];
        else{
            System.out.println("Empty");
            return -1;
        }
    }
    //delete
    public void deletequeue(){
        arr=null;
        System.out.println("Deleted");
    }


}