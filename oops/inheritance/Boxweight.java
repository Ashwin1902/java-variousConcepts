package inheritance;
//child class of box
public class Boxweight extends Box{
    double weight;

    public Boxweight(){
        this.weight=-1;
    }

    public Boxweight(double l,double w,double h,double weight){
        super(l, w, h);
        this.weight=weight;
    }

   /*  @Override*/
    public void example(){
        System.out.println("Boxweight wala function");
    }
}
