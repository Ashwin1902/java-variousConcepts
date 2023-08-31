public class Stack {
    int[] arr;
    int topofstack;
    
    //creation
    public Stack(int size){
        this.arr=new int[size];
        this.topofstack=-1;
        System.out.println("Stack created of size: "+ size);
    }
    //isEmpty
    public boolean isEmpty(){
        if(topofstack==-1){
            return true;
        }
        else{
            return false;
        }
    }

    //isFull

    public boolean isFull(){
        if(topofstack==arr.length-1){
            System.out.println("The stack is full");
            return true;
        }else{
            return false;
        }
    }

    //Push
    public void Push(int value){
        if(isFull()){
            System.out.println("The stack is full,cannot add value");
        }else{
            arr[topofstack+1]=value;
            topofstack++;
            System.out.println("value inserted");
        }
    }

    //Pop
    public int Pop(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }else{
            int topstack=arr[topofstack];
            topofstack--;
            return topstack;
        }
    }

    //Peek
    public int Peek(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return -1;
        }else{
            return arr[topofstack];
        }
    }
    //delete
    public void deleteStack(){
        arr=null;
        System.out.println("The Stack is deleted");
    }

}
