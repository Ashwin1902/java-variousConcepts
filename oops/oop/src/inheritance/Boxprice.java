package inheritance;
//child class of boxweight
public class Boxprice extends Boxweight{
    double price;

    public Boxprice(){
        this.price=-1;
    }
    
    public Boxprice(double l,double w,double h,double weight,double price){
        super(l, w, h, weight);
        this.price=price;
    }
}
