package Domain;

import Buffer.BufferReparacionesCarretera;
import Buffer.BufferSemaforo;
import GUI.VentanaPrincipal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vehiculo extends Thread {

    private ArrayList<ParadaCarro> arrayParadasCarro;
    private ArrayList<ParadaBus> arrayParadasBus;
    private char letra;
    private double x;
    private double y;
    private double velocidadMovimiento;
    private int velocidad;
    private char direccion;
    private boolean ejecutar;
    private BufferReparacionesCarretera reparacionesBuffer;
    private BufferSemaforo semaforoBuffer;

    public Vehiculo(ArrayList<ParadaCarro> arrayParadasCarro, ArrayList<ParadaBus> arrayParadasBus, char letra, double x, double y, char direccion, int capacidad) throws IOException {
        this.arrayParadasCarro = arrayParadasCarro;
        this.arrayParadasBus = arrayParadasBus;
        this.letra = letra;
        this.x = x;
        this.y = y;
        this.velocidadMovimiento = 0.3;
        this.velocidad = (int) (Math.random() * 4 + 1);
        this.ejecutar = true;
        this.direccion = direccion;
        this.reparacionesBuffer = new BufferReparacionesCarretera();
        this.semaforoBuffer = new BufferSemaforo();

    }

    @Override
    public void run() {
        while (this.ejecutar) {
            try {
                this.choqueVehiculos();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                paradasVehiculo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                reparacionesCalle();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                semaforo();
            } catch (InterruptedException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Thread.sleep(velocidad);
                this.direccion = Direccion.getDireccion(this.x, this.y, this.direccion);
            } catch (InterruptedException ex) {
                Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (direccion) {
                case 'n':
                    y -= velocidadMovimiento;
                    break;
                case 's':
                    y += velocidadMovimiento;
                    break;
                case 'e':
                    x += velocidadMovimiento;
                    break;
                case 'w':
                    x -= velocidadMovimiento;
                    break;
                default:
                    break;
            } // switch
        }
    }

    private void reparacionesCalle() throws InterruptedException {
        int xReparacion, yReparacion;
        for (int i = 0; i < VentanaPrincipal.reparaciones.size(); i++) {
            xReparacion = VentanaPrincipal.reparaciones.get(i).getX();
            yReparacion = VentanaPrincipal.reparaciones.get(i).getY();

            switch (direccion) {
                case 'n':
                    yReparacion += 30;
                    break;
                case 's':
                    yReparacion -= 30;
                    break;
                case 'e':
                    xReparacion -= 30;
                    break;
                case 'w':
                    xReparacion += 30;
                    break;
                default:
                    break;
            } // switch

            if ((int) this.x == xReparacion && (int) this.y == yReparacion) {
                setReparacionesBuffer(VentanaPrincipal.reparaciones.get(i).getReparacionesBuffer());
                this.reparacionesBuffer.elquemedaelwait();
            }
        } // for reparaciones
    }

    private void semaforo() throws InterruptedException {
        for (int i = 0; i < VentanaPrincipal.semaforos.length; i++) {

            if ((this.x >= VentanaPrincipal.semaforos[i].getX() - 25 && this.x <= VentanaPrincipal.semaforos[i].getX() + 50)
                    && (this.y >= VentanaPrincipal.semaforos[i].getY() - 25 && this.y <= VentanaPrincipal.semaforos[i].getY() + 49)) {
                setSemaforoBuffer(VentanaPrincipal.semaforos[i].getBufferSemaforo());
                this.semaforoBuffer.getDireccion(this.direccion);
            }
        }
    }

    private void choqueVehiculos() throws InterruptedException {
        int xColision, yColision;

        for (int i = 0; i < VentanaPrincipal.carros.size(); i++) {
            xColision = (int) VentanaPrincipal.carros.get(i).getX();
            yColision = (int) VentanaPrincipal.carros.get(i).getY();

            switch (direccion) {
                case 'n':
                    yColision += 30;
                    break;
                case 's':
                    yColision -= 30;
                    break;
                case 'e':
                    xColision -= 30;
                    break;
                case 'w':
                    xColision += 30;
                    break;
                default:
                    break;
            } // switch

            if ((int) this.x == xColision && (int) this.y == yColision) {

                Thread.sleep(1000);

            }
        } //for

        for (int i = 0; i < VentanaPrincipal.buses.size(); i++) {
            xColision = (int) VentanaPrincipal.buses.get(i).getX();
            yColision = (int) VentanaPrincipal.buses.get(i).getY();

            switch (direccion) {
                case 'n':
                    yColision += 25;
                    break;
                case 's':
                    yColision -= 25;
                    break;
                case 'e':
                    xColision -= 25;
                    break;
                case 'w':
                    xColision += 25;
                    break;
                default:
                    break;
            } // switch

            if ((int) this.x == xColision && (int) this.y == yColision) {
                Thread.sleep(this.velocidad * VentanaPrincipal.buses.get(i).getVelocidad() + 25);
            }
        } //for

    } // choqueAutos

    public static int[][] puntosParadas(String nombreParada) {
        int[][] puntos = new int[2][2];

        if (nombreParada.equalsIgnoreCase("p1")) {
            puntos[0][0] = 61;//x1
            puntos[1][0] = 62;//x2
            puntos[0][1] = 0;//y1
            puntos[1][1] = 27;//y2
        } else if (nombreParada.equalsIgnoreCase("p2")) {
            puntos[0][0] = 171;//x1
            puntos[1][0] = 171;//x2
            puntos[0][1] = 0;//y1
            puntos[1][1] = 27;//y2
        } else if (nombreParada.equalsIgnoreCase("p3")) {
            puntos[0][0] = 312;//x1
            puntos[1][0] = 313;//x2
            puntos[0][1] = 0;//y1
            puntos[1][1] = 27;//y2
        } else if (nombreParada.equalsIgnoreCase("p4")) {
            puntos[0][0] = 455;//x1
            puntos[1][0] = 456;//x2
            puntos[0][1] = 0;//y1
            puntos[1][1] = 27;//y2
        } else if (nombreParada.equalsIgnoreCase("p5")) {
            puntos[0][0] = 574;//x1
            puntos[1][0] = 575;//x2
            puntos[0][1] = 0;//y1
            puntos[1][1] = 27;//y2
        } else if (nombreParada.equalsIgnoreCase("p6")) {
            puntos[0][0] = 0;//x1
            puntos[1][0] = 27;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p7")) {
            puntos[0][0] = 120;//x1
            puntos[1][0] = 144;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p8")) {
            puntos[0][0] = 238;//x1
            puntos[1][0] = 261;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p9")) {
            puntos[0][0] = 261;//x1
            puntos[1][0] = 286;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p10")) {
            puntos[0][0] = 378;//x1
            puntos[1][0] = 403;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p11")) {
            puntos[0][0] = 403;//x1
            puntos[1][0] = 421;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 88;//y2
        } else if (nombreParada.equalsIgnoreCase("p12")) {
            puntos[0][0] = 519;//x1
            puntos[1][0] = 543;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p13")) {
            puntos[0][0] = 634;//x1
            puntos[1][0] = 657;//x2
            puntos[0][1] = 57;//y1
            puntos[1][1] = 58;//y2
        } else if (nombreParada.equalsIgnoreCase("p14")) {
            puntos[0][0] = 0;//x1
            puntos[1][0] = 27;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p15")) {
            puntos[0][0] = 120;//x1
            puntos[1][0] = 144;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p16")) {
            puntos[0][0] = 238;//x1
            puntos[1][0] = 261;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p17")) {
            puntos[0][0] = 261;//x1
            puntos[1][0] = 286;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p18")) {
            puntos[0][0] = 378;//x1
            puntos[1][0] = 403;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p19")) {
            puntos[0][0] = 403;//x1
            puntos[1][0] = 421;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p20")) {
            puntos[0][0] = 519;//x1
            puntos[1][0] = 543;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p21")) {
            puntos[0][0] = 634;//x1
            puntos[1][0] = 657;//x2
            puntos[0][1] = 177;//y1
            puntos[1][1] = 178;//y2
        } else if (nombreParada.equalsIgnoreCase("p22")) {
            puntos[0][0] = 61;//x1
            puntos[1][0] = 62;//x2
            puntos[0][1] = 122;//y1
            puntos[1][1] = 148;//y2
        } else if (nombreParada.equalsIgnoreCase("p23")) {
            puntos[0][0] = 171;//x1
            puntos[1][0] = 172;//x2
            puntos[0][1] = 122;//y1
            puntos[1][1] = 148;//y2
        } else if (nombreParada.equalsIgnoreCase("p24")) {
            puntos[0][0] = 312;//x1
            puntos[1][0] = 313;//x2
            puntos[0][1] = 122;//y1
            puntos[1][1] = 148;//y2
        } else if (nombreParada.equalsIgnoreCase("p25")) {
            puntos[0][0] = 455;//x1
            puntos[1][0] = 456;//x2
            puntos[0][1] = 122;//y1
            puntos[1][1] = 148;//y2
        } else if (nombreParada.equalsIgnoreCase("p26")) {
            puntos[0][0] = 574;//x1
            puntos[1][0] = 575;//x2
            puntos[0][1] = 122;//y1
            puntos[1][1] = 148;//y2
        } else if (nombreParada.equalsIgnoreCase("p27")) {
            puntos[0][0] = 0;//x1
            puntos[1][0] = 27;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p28")) {
            puntos[0][0] = 120;//x1
            puntos[1][0] = 144;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p29")) {
            puntos[0][0] = 238;//x1
            puntos[1][0] = 261;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p30")) {
            puntos[0][0] = 261;//x1
            puntos[1][0] = 286;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p31")) {
            puntos[0][0] = 378;//x1
            puntos[1][0] = 403;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p32")) {
            puntos[0][0] = 403;//x1
            puntos[1][0] = 421;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p33")) {
            puntos[0][0] = 519;//x1
            puntos[1][0] = 543;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p34")) {
            puntos[0][0] = 634;//x1
            puntos[1][0] = 657;//x2
            puntos[0][1] = 319;//y1
            puntos[1][1] = 320;//y2
        } else if (nombreParada.equalsIgnoreCase("p35")) {
            puntos[0][0] = 61;//x1
            puntos[1][0] = 61;//x2
            puntos[0][1] = 376;//y1
            puntos[1][1] = 404;//y2
        } else if (nombreParada.equalsIgnoreCase("p36")) {
            puntos[0][0] = 171;//x1
            puntos[1][0] = 172;//x2
            puntos[0][1] = 376;//y1
            puntos[1][1] = 404;//y2
        } else if (nombreParada.equalsIgnoreCase("p37")) {
            puntos[0][0] = 312;//x1
            puntos[1][0] = 312;//x2
            puntos[0][1] = 376;//y1
            puntos[1][1] = 404;//y2
        } else if (nombreParada.equalsIgnoreCase("p38")) {
            puntos[0][0] = 455;//x1
            puntos[1][0] = 456;//x2
            puntos[0][1] = 376;//y1
            puntos[1][1] = 404;//y2
        } else if (nombreParada.equalsIgnoreCase("p39")) {
            puntos[0][0] = 574;//x1
            puntos[1][0] = 575;//x2
            puntos[0][1] = 376;//y1
            puntos[1][1] = 404;//y2
        } else if (nombreParada.equalsIgnoreCase("p40")) {
            puntos[0][0] = 0;//x1
            puntos[1][0] = 27;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p41")) {
            puntos[0][0] = 120;//x1
            puntos[1][0] = 144;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p42")) {
            puntos[0][0] = 238;//x1
            puntos[1][0] = 261;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p43")) {
            puntos[0][0] = 261;//x1
            puntos[1][0] = 286;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p44")) {
            puntos[0][0] = 378;//x1
            puntos[1][0] = 403;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p45")) {
            puntos[0][0] = 403;//x1
            puntos[1][0] = 421;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p46")) {
            puntos[0][0] = 519;//x1
            puntos[1][0] = 543;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p47")) {
            puntos[0][0] = 634;//x1
            puntos[1][0] = 657;//x2
            puntos[0][1] = 433;//y1
            puntos[1][1] = 434;//y2
        } else if (nombreParada.equalsIgnoreCase("p48")) {
            puntos[0][0] = 61;//x1
            puntos[1][0] = 62;//x2
            puntos[0][1] = 494;//y1
            puntos[1][1] = 519;//y2
        } else if (nombreParada.equalsIgnoreCase("p49")) {
            puntos[0][0] = 171;//x1
            puntos[1][0] = 172;//x2
            puntos[0][1] = 494;//y1
            puntos[1][1] = 519;//y2
        } else if (nombreParada.equalsIgnoreCase("p50")) {
            puntos[0][0] = 312;//x1
            puntos[1][0] = 313;//x2
            puntos[0][1] = 494;//y1
            puntos[1][1] = 519;//y2
        } else if (nombreParada.equalsIgnoreCase("p51")) {
            puntos[0][0] = 455;//x1
            puntos[1][0] = 456;//x2
            puntos[0][1] = 494;//y1
            puntos[1][1] = 519;//y2
        } else if (nombreParada.equalsIgnoreCase("p52")) {
            puntos[0][0] = 574;//x1
            puntos[1][0] = 575;//x2
            puntos[0][1] = 493;//y1
            puntos[1][1] = 520;//y2
        }
        return puntos;
    }

    private void paradasVehiculo() throws InterruptedException {
        int[][] paradas;
        if (this.letra == 'c') {//Carro
            ArrayList<ParadaCarro> arrayParadasC;

            for (int i = 0; i < VentanaPrincipal.carros.size(); i++) {
                arrayParadasC = VentanaPrincipal.carros.get(i).getParadaCarros();
                for (int j = 0; j < arrayParadasC.size(); j++) {
                    paradas = puntosParadas(arrayParadasC.get(j).getNombreParada());
                    if ((this.x >= paradas[0][0]
                            && this.x <= paradas[1][0])
                            && (this.y >= paradas[0][1]
                            && this.y <= paradas[1][1])) {

                        if (arrayParadasC.get(j).getCombustible() == 1) {
                            Thread.sleep(3000 / 3);
                        }
                        if (arrayParadasC.get(j).getFrenos() == 1) {
                            Thread.sleep(5000 / 3);
                        }
                        if (arrayParadasC.get(j).getLlantas() == 1) {
                            Thread.sleep(2000 / 3);
                        }
                        if (arrayParadasC.get(j).getTemperatura() == 1) {
                            Thread.sleep(10000 / 3);
                        }

                    }
                }
            }

        } else if (this.letra == 'b') {
            ArrayList<ParadaBus> arrayParadasB;

            for (int i = 0; i < VentanaPrincipal.buses.size(); i++) {
                arrayParadasB = VentanaPrincipal.buses.get(i).getParadaBuses();
                for (int j = 0; j < arrayParadasB.size(); j++) {
                    paradas = puntosParadas(arrayParadasB.get(j).getNombreParada());
                    if ((this.x >= paradas[0][0]
                            && this.x <= paradas[1][0])
                            && (this.y >= paradas[0][1]
                            && this.y <= paradas[1][1])) {
                        int personasABordo = 0;
                        int num = (int) (Math.random() * 2 + 1);
                        int cantidadPersonas = (int) (Math.random() * 5 + 1);
                        if (num == 1) {
                            if (cantidadPersonas + personasABordo <= VentanaPrincipal.buses.get(i).getCapacidad()) {
                                personasABordo += cantidadPersonas;     
                            }
                        } else {
                            if (personasABordo >= cantidadPersonas) {
                                personasABordo -= cantidadPersonas;
                            }
                        }
                    }
                }

            }
        }
    }

    public char getDireccion() {
        return direccion;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getVelocidadMovimiento() {
        return velocidadMovimiento;
    }

    public void setVelocidadMovimiento(double velocidadMovimiento) {
        this.velocidadMovimiento = velocidadMovimiento;
    }

    public boolean isEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(boolean ejecutar) {
        this.ejecutar = ejecutar;
    }

    public BufferReparacionesCarretera getReparacionesBuffer() {
        return reparacionesBuffer;
    }

    public void setReparacionesBuffer(BufferReparacionesCarretera reparacionesBuffer) {
        this.reparacionesBuffer = reparacionesBuffer;
    }

    public BufferSemaforo getSemaforoBuffer() {
        return semaforoBuffer;
    }

    public void setSemaforoBuffer(BufferSemaforo semaforoBuffer) {
        this.semaforoBuffer = semaforoBuffer;
    }

} // fin clase
