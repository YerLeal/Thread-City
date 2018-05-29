package Domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

public class Carro extends Vehiculo {

    private Color color;
    private ArrayList<ParadaCarro> paradaCarros;

    public Carro(Color color, int x, int y, char direccion, ArrayList<ParadaCarro> arrayList) throws IOException {
        super(arrayList,null,'c',x, y, direccion,0);
        this.color = color;
        this.paradaCarros = arrayList;
    } // constructor

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<ParadaCarro> getParadaCarros() {
        return paradaCarros;
    }

    public void setParadaCarros(ArrayList<ParadaCarro> paradaCarros) {
        this.paradaCarros = paradaCarros;
    }

    public void draw(Graphics2D g2) {
        if (isEjecutar()) {
            g2.setColor(color);
            g2.fillOval((int) getX(), (int) getY(), 25, 25);
        }
    } // draw

} // end class
