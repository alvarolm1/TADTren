public class Asiento {

    private int fila;
    private int columna;
    private boolean ocupado;
    private String id;

    // ÁRBOL BINARIO ALTURA 2?

    public Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void ocuparAsiento(String id) {
        this.ocupado = true;
        this.id = id;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    @Override
    public String toString() {
        return "Fila " + fila + " Columna " + columna + " [" + id + "]";
    }
}