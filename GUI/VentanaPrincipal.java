package GUI;

import Domain.Bus;
import Domain.Carro;
import Domain.Ciudad;
import Domain.Reparacion;
import Buffer.BufferReparacionesCarretera;
import Buffer.BufferSemaforo;
import Domain.ParadaBus;
import Domain.ParadaCarro;
import Domain.Semaforo;
import Domain.Vehiculo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipal extends JPanel implements ActionListener, MouseListener, Runnable {

    private Graphics2D g2;
    private Ciudad ciudad;
    private BufferedImage bufferedImageCity;
    private JButton jbStart, jbLoad, jbNewBus, jbNewCar, jbStop, jbNuevaReparacion;
    public static ArrayList<Carro> carros = new ArrayList<Carro>();
    public static ArrayList<Bus> buses = new ArrayList<Bus>();
    public static ArrayList<Reparacion> reparaciones = new ArrayList<Reparacion>();
//    public static ArrayList<ParadaCarro> paradaCarros = new ArrayList<ParadaCarro>();
    public static Semaforo[] semaforos;
    private boolean errorVehiculo = false;

    private Thread thread;

    public VentanaPrincipal() {
        this.setLayout(null);

        semaforos = new Semaforo[2];
        try {
            semaforos[0] = new Semaforo(new BufferSemaforo(), 238, 238);
            semaforos[1] = new Semaforo(new BufferSemaforo(), 378, 238);
            semaforos[0].start();
            semaforos[1].start();
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.addMouseListener(this);
        try {
            this.ciudad = new Ciudad();
            this.ciudad.setPosicion(0, 0);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.init();
    } // constructor

    private void init() {

        this.jbStart = new JButton("Iniciar");
        this.jbLoad = new JButton("Cargar");
        this.jbNewBus = new JButton("Bus");
        this.jbNewCar = new JButton("Carro");
        this.jbStop = new JButton("Stop");
        this.jbNuevaReparacion = new JButton("Reparación");

        this.jbStart.setSize(80, 50);
        this.jbLoad.setSize(80, 50);
        this.jbNewBus.setSize(80, 50);
        this.jbNewCar.setSize(80, 50);
        this.jbStop.setSize(80, 50);
        this.jbNuevaReparacion.setSize(99, 50);

        this.jbStart.setLocation(0, 520);
        this.jbLoad.setLocation(80, 520);
        this.jbNewBus.setLocation(160, 520);
        this.jbNewCar.setLocation(240, 520);
        this.jbStop.setLocation(320, 520);
        this.jbNuevaReparacion.setLocation(400, 520);

        this.jbStart.addActionListener(this);
        this.jbLoad.addActionListener(this);
        this.jbNewBus.addActionListener(this);
        this.jbNewCar.addActionListener(this);
        this.jbStop.addActionListener(this);
        this.jbNuevaReparacion.addActionListener(this);

        this.jbStart.setFocusable(false);
        this.jbLoad.setFocusable(false);
        this.jbNewBus.setFocusable(false);
        this.jbNewCar.setFocusable(false);
        this.jbStop.setFocusable(false);
        this.jbNuevaReparacion.setFocusable(false);

        this.add(this.jbStart);
        this.add(this.jbLoad);
        this.add(this.jbNewBus);
        this.add(this.jbNewCar);
        this.add(this.jbStop);
        this.add(this.jbNuevaReparacion);
    } // init

    @Override
    public void run() {
        this.bufferedImageCity = new BufferedImage(665, 519, BufferedImage.TYPE_INT_RGB);
        this.g2 = (Graphics2D) this.bufferedImageCity.getGraphics();

        while (true) {
            draw();
            drawToScreen();
        }
    } // run

    private void draw() {
        this.ciudad.draw(this.g2);
        for (int i = 0; i < this.carros.size(); i++) {
            this.carros.get(i).draw(this.g2);
        }

        for (int i = 0; i < this.buses.size(); i++) {
            this.buses.get(i).draw(this.g2);
        }

        for (int i = 0; i < this.reparaciones.size(); i++) {
            this.reparaciones.get(i).draw(this.g2);
        }

        for (int i = 0; i < 2; i++) {
            this.semaforos[i].draw(g2);

        }
    } // draw

    private void actualizaPosicion() {
        for (int i = 0; i < this.carros.size(); i++) {
            String s = this.carros.get(i).getParadaCarros().get(0).getNombreParada();
            int[][] m = Vehiculo.puntosParadas(s);
            carros.get(i).setX(m[0][0]);
            carros.get(i).setY(m[0][1]);
        }
    } // actualizaPosicion

    private void drawToScreen() {
        Graphics g = this.getGraphics();
        g.drawImage(bufferedImageCity, 0, 0, 665, 519, null);
        g.dispose();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbNewCar) {//********************AGREGA CARRO
            try {
                ArrayList<ParadaCarro> paradasPorCarro = eleccionParadasCarro();
                if (!this.errorVehiculo) {
                    carros.add(new Carro(colorSeleccionado(), 0, 0, 'e', paradasPorCarro));
                }
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (e.getSource() == jbStart) {//********************STAR HILOS
            for (int i = 0; i < carros.size(); i++) {
                if (!carros.get(i).isAlive()) {
                    carros.get(i).start();
                }
            }
            for (int i = 0; i < this.buses.size(); i++) {
                if (!this.buses.get(i).isAlive()) {
                    this.buses.get(i).start();
                }
            }
        } else if (e.getSource() == jbNewBus) {//********************AGREGA BUS
            try {
                ArrayList<ParadaBus> paradasPorBus = eleccionParadasBus();
                if (!this.errorVehiculo) {
                    this.buses.add(new Bus(paradasPorBus, colorSeleccionado(), 0, 0, 'e', capacidadSeleccionada()));
                }
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == this.jbNuevaReparacion) {
            try {
                //********************AGREGA REPARACION
                this.reparaciones.add(new Reparacion(new BufferReparacionesCarretera()));
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.reparaciones.get(this.reparaciones.size() - 1).start();
        }
    } // actionPerformed

    private Color colorSeleccionado() {
        Color c;
        String[] color = {"Amarillo", "Anaranjado", "Azul", "Blanco", "Magenta", "Negro", "Rojo", "Rosado", "Verde"};

        JComboBox colores = new JComboBox(color);
        colores.setEditable(false);

        JOptionPane.showMessageDialog(null, colores, "Elija el color del vehículo", JOptionPane.QUESTION_MESSAGE);

        String colorSeleccionado = colores.getSelectedItem().toString();

        switch (colorSeleccionado) {
            case "Azul":
                c = Color.BLUE;
                break;
            case "Amarillo":
                c = Color.YELLOW;
                break;
            case "Rojo":
                c = Color.RED;
                break;
            case "Verde":
                c = Color.GREEN;
                break;
            case "Negro":
                c = Color.BLACK;
                break;
            case "Blanco":
                c = Color.WHITE;
                break;
            case "Rosado":
                c = Color.PINK;
                break;
            case "Anaranjado":
                c = Color.ORANGE;
                break;
            case "Magenta":
                c = Color.MAGENTA;
                break;
            default:
                c = null;
                break;
        }
        return c;
    } // colorSeleccionado

    private int capacidadSeleccionada() {
        boolean error = false;
        int capacidad = 0;
        do {
            error = false;
            try {
                capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del bus"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero", "Error", 0);
                error = true;
            }
        } while (error);
        return capacidad;
    } // capacidadSeleccionada

    private ArrayList<ParadaCarro> eleccionParadasCarro() {
        this.errorVehiculo = false;
        ArrayList<String> paradas = new ArrayList<>();
        ArrayList<ParadaCarro> paradaCarros = new ArrayList<>();
        String data = "";

        try {
            while (!data.equals("0")) {
                data = JOptionPane.showInputDialog("Ingrese parada(NombreParada,Combustible,Llantas,Frenos,Temperatura), 0 para salir");
                if (!data.equals("0")) {
                    paradas.add(data);
                }
            }
        } catch (NullPointerException npe) {
            this.errorVehiculo = true;
            JOptionPane.showMessageDialog(null, "Carro cancelado");
        }
        String nombreParada = "";
        int combustible = 0, llantas = 0, frenos = 0, temperatura = 0;

        for (int i = 0; i < paradas.size(); i++) {
            String s = paradas.get(i);
            StringTokenizer st = new StringTokenizer(s, ",");
            int contadorDatos = 1;
            while (contadorDatos <= 5) {
                switch (contadorDatos) {
                    case 1:
                        nombreParada = st.nextToken().trim();
                        break;
                    case 2:
                        combustible = Integer.parseInt(st.nextToken().trim());
                        break;
                    case 3:
                        llantas = Integer.parseInt(st.nextToken().trim());
                        break;
                    case 4:
                        frenos = Integer.parseInt(st.nextToken().trim());
                        break;
                    case 5:
                        temperatura = Integer.parseInt(st.nextToken().trim());
                        break;
                    default:
                        break;
                }
                contadorDatos++;
            } // while
            ParadaCarro paradaCarro = new ParadaCarro(nombreParada, combustible, llantas, frenos, temperatura);
            paradaCarros.add(paradaCarro);
        }
        return paradaCarros;
    } // eleccionParadasCarro

    private ArrayList<ParadaBus> eleccionParadasBus() {
        this.errorVehiculo = false;
        ArrayList<ParadaBus> paradaBus = new ArrayList<>();
        ParadaBus nombreParada = new ParadaBus("");
        String s = JOptionPane.showInputDialog("Ingrese las paradas del bus separadas por , ");
        try {
            StringTokenizer st = new StringTokenizer(s, ",");

            while (st.hasMoreTokens()) {
                nombreParada = new ParadaBus(st.nextToken());
                paradaBus.add(nombreParada);
            }
        } catch (NullPointerException npe) {
            this.errorVehiculo = true;
            JOptionPane.showMessageDialog(null, "Bus cancelado");
        }
        return paradaBus;
    } // eleccionParadasBus

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        JOptionPane.showMessageDialog(this, "x= " + x + " y= " + y);
    } // mouseClicked

    @Override
    public void mousePressed(MouseEvent me) {;
    }

    @Override
    public void mouseReleased(MouseEvent me) {;
    }

    @Override
    public void mouseEntered(MouseEvent me) {;
    }

    @Override
    public void mouseExited(MouseEvent me) {;
    }

} // class
