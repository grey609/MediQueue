package cr.ac.ufidelitas.mediqueue.main;

import cr.ac.ufidelitas.mediqueue.modulo1.ConfigService;
import cr.ac.ufidelitas.mediqueue.modulo1.Configuracion;
import cr.ac.ufidelitas.mediqueue.modulo2.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =====================================================
        // LOGIN (PARA PRUEBAS)
        // =====================================================

        /*
        boolean acceso = false;

        while (!acceso) {
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Contraseña: ");
            String password = sc.nextLine();

            if (Login.autenticar(usuario, password)) {
                acceso = true;
                System.out.println("✅ Acceso permitido");
            } else {
                System.out.println("❌ Credenciales incorrectas");
            }
        }
        */

        System.out.println("Sistema MediQueue iniciado");

        // =====================================================
        // MÓDULO 1 → CONFIGURACIÓN
        // =====================================================
        ConfigService configService = new ConfigService();
        Configuracion config = configService.cargar();

        if (config == null) {
            System.out.println("❌ No existe configuración inicial");
            System.out.println("👉 Debes ejecutar primero el módulo 1.0");
            return;
        }

        System.out.println("✅ Configuración cargada");
        System.out.println("🏥 Sede: " + config.getSede().getNombre());

        // =====================================================
        // MÓDULO 2 → COLAS + PACIENTES
        // =====================================================
        GestorColas gestor = new GestorColas();

        // Cargar datos existentes
        gestor.cargarTodo();

        boolean salir = false;

        while (!salir) {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Atender Paciente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                // =====================================================
                // REGISTRAR PACIENTE (SIN DATOS QUEMADOS)
                // =====================================================
                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Identificación: ");
                    String identificacion = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tipo Seguro: ");
                    String seguro = sc.nextLine();

                    System.out.print("Tipo Paciente (P/N): ");
                    String tipoPacienteInput = sc.nextLine();

                    System.out.print("Tipo Atención (C/S/E): ");
                    String tipoAtencion = sc.nextLine();

                    Paciente paciente;

                    // POLIMORFISMO
                    if (tipoPacienteInput.equalsIgnoreCase("P")) {
                        paciente = new PacientePreferencial(id, nombre, identificacion, edad, seguro);
                    } else {
                        paciente = new PacienteNormal(id, nombre, identificacion, edad, seguro);
                    }

                    // CREAR TIQUETE
                    Tiquete tiquete = new Tiquete(paciente, tipoAtencion);

                    gestor.registrarPaciente(tiquete);

                    break;

                // =====================================================
                // ATENDER PACIENTE
                // =====================================================
                case 2:

                    Tiquete siguiente = gestor.siguientePaciente();

                    if (siguiente != null) {
                        siguiente.atender();
                        System.out.println("✅ Atendiendo:");
                        System.out.println(siguiente);
                    } else {
                        System.out.println("⚠ No hay pacientes en cola");
                    }

                    break;

                // =====================================================
                // SALIR
                // =====================================================
                case 3:
                    salir = true;
                    System.out.println("👋 Cerrando sistema...");
                    break;

                default:
                    System.out.println("❌ Opción inválida");
            }
        }
    }
}

