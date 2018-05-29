package Domain;

import Buffer.BufferReparacionesCarretera;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ciudad {
    private BufferedImage imagen;
    private BufferReparacionesCarretera bufferReparaciones;
    private int x;
    private int y;
    
    public Ciudad() throws IOException{
        this.imagen=ImageIO.read(getClass().getResourceAsStream("/assets/city.png"));
        this.bufferReparaciones = new BufferReparacionesCarretera();
    } // constructor
    
    public void setPosicion(int x, int y){
        this.x=x;
        this.y=y;
    } // setPosicion
    
    public void draw(Graphics2D g2){
        g2.drawImage(this.imagen, this.x, this.y, null);
    }// draw
    
} // fin clase
