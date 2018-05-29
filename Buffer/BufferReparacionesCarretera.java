package Buffer;

public class BufferReparacionesCarretera implements Buffer{

    private boolean reparacion;
    
    @Override
    public synchronized void set(boolean reparacion) {
        this.reparacion = reparacion;
        notifyAll();   
    }
    
    public synchronized void elquemedaelwait() throws InterruptedException{
        if(this.reparacion){
            wait();
        }
    }
}
