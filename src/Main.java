import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // PILA DINÁMICA DE TRENES
        Tren tren = null; // inicializamos tren a null
        menuOpciones(tren);
    }

    public static void menuOpciones(Tren tren){

        try {
            while (true) { // loop infinito a menos que se introduzca la función Salir

                // MENÚ
                System.out.println("1] Crear nuevo tren");
                System.out.println("2] Comprar número de billetes");
                System.out.println("3] Mostrar tren");
                System.out.println("4] Salir");
                System.out.print("Introduzca una opción: ");

                int opcion = scanner.nextInt();
                //scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduzca el número máximo de vagones: ");
                        int maxVagones = scanner.nextInt();
                        System.out.print("Introduzca el número de filas por vagón: ");
                        int filasPorVagon = scanner.nextInt();
                        tren = new Tren(maxVagones, filasPorVagon);
                        break;
                    case 2:
                        if (tren == null) {
                            System.out.println("\nNo se ha creado ningún tren. Inténtelo de nuevo\n");
                            break;
                        }
                        System.out.print("Introduce el número de billetes a comprar: ");
                        int numBilletes = scanner.nextInt();
                        for (int i = 1; i <= numBilletes; i++) {
                            Asiento asiento = tren.reservarAsiento("P" + i);
                            if (asiento == null) {
                                System.out.println("No hay asientos disponibles");
                                break;
                            }
                            System.out.println("Asiento reservado: " + asiento);
                        }
                        break;
                    case 3:
                        if (tren == null) {
                            System.out.println("\nNo se ha creado ningún tren. Inténtelo de nuevo\n");
                            break;
                        }
                        System.out.println(tren.toString());
                        break;
                    case 4:
                        return;
                }
            }
        }catch (InputMismatchException e) {
            System.out.println("Debe introducir un carácter númerico");
        }
    }

}
