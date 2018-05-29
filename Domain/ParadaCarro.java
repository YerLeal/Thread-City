package Domain;

public class ParadaCarro {

    private String nombreParada;
    private int combustible, llantas, frenos, temperatura;

    public ParadaCarro(String nombreParada, int combustible, int llantas, int frenos, int temperatura) {
        this.nombreParada = nombreParada;
        this.combustible = combustible;
        this.llantas = llantas;
        this.frenos = frenos;
        this.temperatura = temperatura;
    }

    public String getNombreParada() {
        return nombreParada;
    }

    public void setNombreParada(String nombreParada) {
        this.nombreParada = nombreParada;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setCombustible(int combustible) {
        this.combustible = combustible;
    }

    public int getLlantas() {
        return llantas;
    }

    public void setLlantas(int llantas) {
        this.llantas = llantas;
    }

    public int getFrenos() {
        return frenos;
    }

    public void setFrenos(int frenos) {
        this.frenos = frenos;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
   
}
