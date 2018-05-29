package Domain;

import Buffer.BufferSemaforo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Semaforo extends Thread {

    private BufferSemaforo bufferSemaforo;
    private int x, y;
    private boolean paso;
    private BufferedImage arriba, abajo;

    public Semaforo(BufferSemaforo bufferSemaforo, int x, int y) throws IOException {

        this.bufferSemaforo = bufferSemaforo;
        this.x = x;
        this.y = y;
        this.paso = true;
        this.bufferSemaforo.set(paso);
        
        this.abajo = ImageIO.read(getClass().getResourceAsStream("/assets/semaforoNorte.png"));
        this.arriba = ImageIO.read(getClass().getResourceAsStream("/assets/semaforoSur.png"));
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                this.bufferSemaforo.set(!this.paso);
                this.paso = !this.paso;
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (this.paso) {//flecha arriba
            g2.drawImage(this.arriba, this.x, this.y, null);
        } else { // flecha abajo
            g2.drawImage(this.abajo, this.x, this.y, null);
        }
    }

    public BufferSemaforo getBufferSemaforo() {
        return bufferSemaforo;
    }

    public void setBufferSemaforo(BufferSemaforo bufferSemaforo) {
        this.bufferSemaforo = bufferSemaforo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPaso() {
        return paso;
    }

    public void setPaso(boolean paso) {
        this.paso = paso;
    }

    public BufferedImage getArriba() {
        return arriba;
    }

    public void setArriba(BufferedImage arriba) {
        this.arriba = arriba;
    }

    public BufferedImage getAbajo() {
        return abajo;
    }

    public void setAbajo(BufferedImage abajo) {
        this.abajo = abajo;
    }
    
    
}
