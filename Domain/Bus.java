package Domain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

public class Bus extends Vehiculo {

    private Color color;
    private int capacidad;
    private ArrayList<ParadaBus> paradas;

    public Bus(ArrayList<ParadaBus> arrayList,Color color, double x, double y, char direccion, int capacidad) throws IOException {
        super(null,arrayList,'b',x, y, direccion, capacidad);
        this.paradas = arrayList;
        this.color = color;
        this.capacidad = capacidad;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<ParadaBus> getParadaBuses() {
        return paradas;
    }

    public void setParadas(ArrayList<ParadaBus> paradas) {
        this.paradas = paradas;
    }

    public void draw(Graphics2D g2) {
        if (isEjecutar()) {
            g2.setColor(this.color);
            g2.fillRect((int) getX(), (int) getY(), 25, 25);
        }
    }

} // fin clase
