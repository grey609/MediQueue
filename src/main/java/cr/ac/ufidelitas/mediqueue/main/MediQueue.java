
package cr.ac.ufidelitas.mediqueue.main;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class MediQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n=== SISTEMA MEDIQUEUE ===");
            System.out.println("1. Configuración inicial");
            System.out.println("2. Registro de pacientes");
            System.out.println("3. Atención de pacientes");
            System.out.println("4. Administración de salas");
            System.out.println("5. Historial y búsquedas");
            System.out.println("6. Gestión de sedes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Módulo Configuración (pendiente)");
                    break;
                case 2:
                    System.out.println("Registro de pacientes (pendiente)");
                    break;
                case 3:
                    System.out.println("Atención de pacientes (pendiente)");
                    break;
                case 4:
                    System.out.println("Administración de salas (pendiente)");
                    break;
                case 5:
                    System.out.println("Historial y búsquedas (pendiente)");
                    break;
                case 6:
                    System.out.println("Gestión de sedes (pendiente)");
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
