
class Vagon implements DATOS{

    private int numVagon;
    private Asiento[][] asientos;
    private int filas;
    private int columnas;

    public Vagon(int numVagon, int filas) {
        this.numVagon = numVagon;
        this.filas = filas;
        this.columnas = COL_ASIENTOS;
        this.asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asientos[i][j] = new Asiento(i + 1, j + 1);
            }
        }
    }

    public Asiento reservarAsiento(String id) {
        Asiento asiento = null;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                asiento = asientos[i][j];
                if (!asiento.estaOcupado()) {
                    asiento.ocuparAsiento(id);
                    return asiento;
                }
            }

        }
        return asiento;
    }


    public boolean todosLosAsientosOcupados() {
        return true; //NO
    }

    public int numPasajeros() {
        return 10; //NO
    }
}