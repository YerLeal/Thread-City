package Domain;

import Buffer.BufferReparacionesCarretera;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Reparacion extends Thread {

    private BufferReparacionesCarretera bufferReparaciones;
    private int x, y;
    private boolean ejecucion;
    private Point[] posicion;
    private int reparacion;
    private BufferedImage imagen;

    public Reparacion(BufferReparacionesCarretera bufferReparaciones) throws IOException {

        this.bufferReparaciones = bufferReparaciones;
        this.bufferReparaciones.set(true);
        this.ejecucion = true;
        this.posicion = posicion();
        this.reparacion = (int) (Math.random() * 3 + 1);
        this.x = (int) this.posicion[0].getX();
        this.y = (int) this.posicion[0].getY();
        this.imagen = ImageIO.read(getClass().getResourceAsStream("/assets/sRojo.png"));

    }

    private Point[] posicion() {
        Point[][] matrizPuntos = new Point[18][2];
        matrizPuntos[0][0] = new Point(50, 0);//a
        matrizPuntos[0][1] = new Point(100, 27);//a
        matrizPuntos[1][0] = new Point(450, 0);//b
        matrizPuntos[1][1] = new Point(500, 27);//b
        matrizPuntos[2][0] = new Point(238, 87);//c
        matrizPuntos[2][1] = new Point(261, 127);//c
        matrizPuntos[3][0] = new Point(286, 127);//d
        matrizPuntos[3][1] = new Point(332, 147);//d
        matrizPuntos[4][0] = new Point(0, 147);//e
        matrizPuntos[4][1] = new Point(27, 192);//e
        matrizPuntos[5][0] = new Point(519, 147);//f
        matrizPuntos[5][1] = new Point(543, 147);//f
        matrizPuntos[6][0] = new Point(634, 147);//g
        matrizPuntos[6][1] = new Point(657, 192);//g
        matrizPuntos[7][0] = new Point(155, 238);//h
        matrizPuntos[7][1] = new Point(202, 260);//h
        matrizPuntos[8][0] = new Point(27, 260);//i
        matrizPuntos[8][1] = new Point(54, 286);//i
        matrizPuntos[9][0] = new Point(421, 260);//j
        matrizPuntos[9][1] = new Point(470, 286);//j
        matrizPuntos[10][0] = new Point(238, 331);//k
        matrizPuntos[10][1] = new Point(261, 376);//k
        matrizPuntos[11][0] = new Point(470, 376);//l
        matrizPuntos[11][1] = new Point(519, 404);//l
        matrizPuntos[12][0] = new Point(595, 376);//m
        matrizPuntos[12][1] = new Point(624, 404);//m
        matrizPuntos[13][0] = new Point(120, 404);//n
        matrizPuntos[13][1] = new Point(144, 448);//n
        matrizPuntos[14][0] = new Point(0, 494);//o
        matrizPuntos[14][1] = new Point(27, 519);//o
        matrizPuntos[15][0] = new Point(300, 494);//p
        matrizPuntos[15][1] = new Point(344, 519);//p
        matrizPuntos[16][0] = new Point(459, 494);//q
        matrizPuntos[16][1] = new Point(491, 519);//q
        matrizPuntos[17][0] = new Point(634, 494);//r
        matrizPuntos[17][1] = new Point(657, 519);//r
//        matrizPuntos[18][0] = 
//        matrizPuntos[18][1] = new Point(277, 287);//s
//        matrizPuntos[19][0] = 
//        matrizPuntos[19][1] = new Point(413, 285);//t

        int x = (int) (Math.random() * 17);
        Point a[] = new Point[2];
        a[0] = matrizPuntos[x][0];
        a[1] = matrizPuntos[x][1];

        return a;
    }

    @Override
    public void run() {
        try {
            switch (reparacion) {
                case 1:
                    Thread.sleep(10000);
                    break;
                case 2:
                    Thread.sleep(5000);
                    break;
                case 3:
                    int num = (int) (Math.random() * 2 + 1);
                    if (num == 1) {
                        setX(238);
                        setY(238);//s
                    } else {
                        setX(378);
                        setY(238);//t
                    }
                    Thread.sleep(15000);
                    break;
                default:
                    break;
            }
            this.bufferReparaciones.set(false);
            ejecucion = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Reparacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g2) {
        if (ejecucion) {
//            g2.drawOval(this.x, this.y, 25, 25);
            g2.drawImage(imagen, x, y, null);
        }
    }

    public BufferReparacionesCarretera getReparacionesBuffer() {
        return bufferReparaciones;
    }

    public void setReparacionesBuffer(BufferReparacionesCarretera reparacionesBuffer) {
        this.bufferReparaciones = reparacionesBuffer;
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

    public boolean isEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(boolean ejecucion) {
        this.ejecucion = ejecucion;
    }

}
