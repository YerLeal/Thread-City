package Buffer;

public class BufferSemaforo implements Buffer {

    private boolean paso;

    @Override
    public synchronized void set(boolean status) {
        this.paso = status;
        notifyAll();
    }

    public synchronized void getDireccion(char direccion) throws InterruptedException {
        if (this.paso && direccion == 'n') {
            wait();
        } else if (!this.paso && direccion == 's') {
            wait();
        }
    }
}
