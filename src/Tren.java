import java.util.ArrayList;
import java.util.List;

public class Tren {

    // DEBERÁ HABER UNA PILA DINÁMICA DE TRENES
    private int maxVagones;
    private int filasPorVagon;
    private List<Vagon> vagones;

    public Tren(int maxVagones, int filasPorVagon) {
        this.maxVagones = maxVagones;
        this.filasPorVagon = filasPorVagon;
        this.vagones = new ArrayList<>();
        vagones.add(new Vagon(1, filasPorVagon));
    }

    public Asiento reservarAsiento(String id) {
        for (Vagon vagon : vagones) {
            Asiento asiento = vagon.reservarAsiento(id);
            if (asiento != null) {
                return asiento;
            }
        }

        if (vagones.size() < maxVagones) {
            Vagon vagon = new Vagon(vagones.size() + 1, filasPorVagon);
            vagones.add(vagon);
            return vagon.reservarAsiento(id);
        }

        return null;
    }

    public int numPasajeros() {
        int numPasajeros = 0;
        for (Vagon vagon : vagones) {
            numPasajeros += vagon.numPasajeros();
        }
        return numPasajeros;
    }

    public boolean trenLleno() {
        for (Vagon vagon : vagones) {
            if (!vagon.todosLosAsientosOcupados()) {
                return false;
            }
        }
        return vagones.size() >= maxVagones;
    }

    @Override
    public String toString() {
        return "\n- Número máximo de vagones: " + maxVagones + "\n- Número de filas por vagón: " + filasPorVagon + "\n- Vagones: " + vagones.toString() + "\n";
    }
}
