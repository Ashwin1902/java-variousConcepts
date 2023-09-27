public class BinaryHeap {
    int arr[];
    int sizeoftree;


    //creation
    public BinaryHeap(int size){
        this.arr=new int[size+1];
        this.sizeoftree=0;
        System.out.println("Heap Created");
    }

    //isempty()
    public boolean isEmpty(){
        if(sizeoftree==0) return true;
        else return false;
    }

    //peek
    public Integer peek(){
        if(isEmpty()){
            System.out.println("Heap is empty");
            return null;
        }
        return arr[1];
    }

    //size of heap;
    public int sizeofHeap(){
        return sizeoftree;
    }

    //levelorder
    public void levelorder(){
        for(int i=1;i<=sizeoftree;i++) System.out.print(arr[i]+" ");
        System.out.println("\n");
    }

    //heapify for insert
    private void heapifyBottomToTop(int index,String heapType){
        int parent=index/2;
        if(index<=1) return;
        if(heapType.equals("Min")){
            if(arr[index]<arr[parent]){
                int tmp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=tmp;
            }
        }
        else if(heapType.equals("Max")){
             if(arr[index]>arr[parent]){
                int tmp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    //insertion
    public void insert(int value,String typeHeap){
        arr[sizeoftree+1]=value;
        sizeoftree++;
        heapifyBottomToTop(sizeoftree, typeHeap);
        System.out.println("Inserted successfully");
    }

    //heapifytoptobottom
    private void heapifytoptobottom(int index,String heaptype){
        int left=index*2;
        int right=(index*2)+1;
        int swapchild=0;
        if(sizeoftree<left) return;
        if(heaptype.equals("Max")){
            if(sizeoftree==left){
                if(arr[index]<arr[left]){
                    int temp=arr[index];
                    arr[index]=arr[left];
                    arr[left]=temp;
                }
                return;
            }
            else{
                if(arr[left]>arr[right]) swapchild=left;
                else swapchild=right;
            }
            if(arr[index]<arr[swapchild]){
                int tmp=arr[index];
                arr[index]=arr[swapchild];
                arr[swapchild]=tmp;
            }
        }
        else if(heaptype.equals("Min")){
            if(sizeoftree==left){
                if(arr[index]>arr[left]){
                    int temp=arr[index];
                    arr[index]=arr[left];
                    arr[left]=temp;
                }
                return;
            }
            else{
                if(arr[left]<arr[right]) swapchild=left;
                else swapchild=right;
            }
            if(arr[index]>arr[swapchild]){
                int tmp=arr[index];
                arr[index]=arr[swapchild];
                arr[swapchild]=tmp;
            }
        }
        heapifytoptobottom(swapchild, heaptype);

    }
 

    //get first val
    public int extracthead(String heaptype){
        if(isEmpty()) return -1;
        else{
            int extractedval=arr[1];
            arr[1]=arr[sizeoftree];
            sizeoftree--;
            heapifytoptobottom(1, heaptype);
            return extractedval;
        }
    }

    //delete
    public void deleteHeap(){
        arr=null;
        System.out.println("Heap deleted");
    }


}
