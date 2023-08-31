package interfaces;

public class car {
    private engine e;
    
    public car(){
        e= new electricengine();
    }

    public void start(){
        e.start();
    }

    public void stop(){
        e.stop();
    }

    public void upgrade(){
        e=new petrolengine();
    }
}
