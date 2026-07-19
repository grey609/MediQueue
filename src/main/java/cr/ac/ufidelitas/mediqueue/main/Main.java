package cr.ac.ufidelitas.mediqueue.main;

import cr.ac.ufidelitas.mediqueue.modulo1.*;
import cr.ac.ufidelitas.mediqueue.modulo2.*;
import cr.ac.ufidelitas.mediqueue.modulo3.*;
import cr.ac.ufidelitas.mediqueue.modulo4.*;
import cr.ac.ufidelitas.mediqueue.modulo1.Usuario;
import cr.ac.ufidelitas.mediqueue.modulo1.ListaUsuarios;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println(" Sistema MediQueue - Bienvenido ");
        System.out.println("======================================");

        // =====================================================
        // CONFIGURACIÓN
        // =====================================================
        ConfigService configService = new ConfigService();
        Configuracion config = configService.cargar();

        if (config == null) {

            System.out.println("\n⚙ Configuracion inicial");

            System.out.print("Nombre de la sede: ");
            String nombreSede = sc.nextLine();

            System.out.print("Salas medicas: ");
            int salas = sc.nextInt();

            System.out.print("Consultorios: ");
            int consultorios = sc.nextInt();

            System.out.print("Emergencias: ");
            int emergencias = sc.nextInt();
            sc.nextLine();

            ListaUsuarios usuarios = new ListaUsuarios();
                usuarios.agregar(
                    new Usuario(
                            "garias",
                            "70021"));
            
                usuarios.agregar(
                          new Usuario(
                                  "mchaves",
                                  "50279"));

                  usuarios.agregar(
                          new Usuario(
                                  "kartavia",
                                  "80284"));

            Sede sede = new Sede(nombreSede, salas, consultorios, emergencias);
            cr.ac.ufidelitas.mediqueue.modulo1.Sala salaPreferencial =
            new cr.ac.ufidelitas.mediqueue.modulo1.Sala(
                    salas,
                    "PREFERENCIAL");

            cr.ac.ufidelitas.mediqueue.modulo1.Sala salaEmergencia =
                    new cr.ac.ufidelitas.mediqueue.modulo1.Sala(
                            salas + 1,
                            "EMERGENCIA_CRITICA");

            Consultorio consultorioPreferencial =
                    new Consultorio(
                            consultorios,
                            "PREFERENCIAL",
                            "GENERAL");

            config = new Configuracion(sede,usuarios, salaPreferencial, salaEmergencia, consultorioPreferencial);

            configService.guardar(config);

            System.out.println("Configuracion guardada");

        } else {

            System.out.println("\nConfiguracion cargada");
            System.out.println("Sede actual: " + config.getSede().getNombre());

            System.out.print("¿Desea reconfigurar? (S/N): ");
            String opc = sc.nextLine();

            if (opc.equalsIgnoreCase("S")) {

                System.out.print("Nombre de la sede: ");
                String nombreSede = sc.nextLine();

                System.out.print("Salas medicas: ");
                int salas = sc.nextInt();

                System.out.print("Consultorios: ");
                int consultorios = sc.nextInt();

                System.out.print("Emergencias: ");
                int emergencias = sc.nextInt();
                sc.nextLine();
                
                ListaUsuarios usuarios = new ListaUsuarios();
                usuarios.agregar(
                    new Usuario(
                            "garias",
                            "70021"));
            
                usuarios.agregar(
                          new Usuario(
                                  "mchaves",
                                  "50279"));

                  usuarios.agregar(
                          new Usuario(
                                  "kartavia",
                                  "80284"));


                Sede sede = new Sede(nombreSede, salas, consultorios, emergencias);
                cr.ac.ufidelitas.mediqueue.modulo1.Sala salaPreferencial =
                  new cr.ac.ufidelitas.mediqueue.modulo1.Sala(
                          salas,
                          "PREFERENCIAL");

                  cr.ac.ufidelitas.mediqueue.modulo1.Sala salaEmergencia =
                          new cr.ac.ufidelitas.mediqueue.modulo1.Sala(
                                  salas + 1,
                                  "EMERGENCIA_CRITICA");

                  Consultorio consultorioPreferencial =
                          new Consultorio(
                                  consultorios,
                                  "PREFERENCIAL",
                                  "GENERAL");

                  config = new Configuracion(sede, usuarios, salaPreferencial, salaEmergencia, consultorioPreferencial);

                configService.guardar(config);

                System.out.println("Configuracion actualizada");
            }
        }

        // =====================================================
        // LOGIN
        // =====================================================
        boolean autenticado = false;

        while (!autenticado) {

            System.out.println("\n=== LOGIN ===");

            System.out.print("Usuario: ");
            String user = sc.nextLine();

            System.out.print("Password: ");
            String pass = sc.nextLine();

            if (Login.autenticar(user, pass, config)) {
                System.out.println("Acceso concedido");
                autenticado = true;
            } else {
                System.out.println("Credenciales incorrectas");
            }
        }

        // =====================================================
        // MÓDULOS
        // =====================================================
        GestorColas gestorColas = new GestorColas();
        gestorColas.cargarTodo();

        GestorAtencion gestorAtencion = new GestorAtencion(gestorColas);
        GestorSalas gestorSalas = new GestorSalas();

        boolean salir = false;

        while (!salir) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Enviar paciente a sala");
            System.out.println("3. Atender paciente en sala");
            System.out.println("4. Ver historial");
            System.out.println("5. Ver estado de salas");
            System.out.println("6. Salir");

            System.out.print("Seleccione opcion: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =====================================================
                // REGISTRAR PACIENTE
                // =====================================================
                case 1:

                    System.out.println("\n=== REGISTRO DE PACIENTE ===");

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Identificacion: ");
                    String cedula = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Seguro (INS / CCSS): ");
                    String seguro = sc.nextLine();
                    System.out.println("\nPrioridad médica:");

                  System.out.println("1 - Critico");
                  System.out.println("2 - Urgente");
                  System.out.println("3 - Regular");
                  System.out.println("4 - Control");

                  System.out.print("Seleccione prioridad: ");

                  int opcionPrioridad =
                          Integer.parseInt(sc.nextLine());

                  String prioridad = "Regular";

                  switch (opcionPrioridad) {

                      case 1:
                          prioridad = "Critico";
                          break;

                      case 2:
                          prioridad = "Urgente";
                          break;

                      case 3:
                          prioridad = "Regular";
                          break;

                      case 4:
                          prioridad = "Control";
                          break;
                  }

                    System.out.println("\nTipo de paciente:");
                    System.out.println("P - Preferencial");
                    System.out.println("N - Normal");
                    System.out.print("Seleccione (P/N): ");

                    String tipoPaciente = sc.nextLine();

                    System.out.println("\nTipo de atencion:");
                    System.out.println("C - Consulta Externa");
                    System.out.println("S - Sala / Salon");
                    System.out.println("E - Emergencias");
                    System.out.print("Seleccione (C/S/E): ");

                    String tipoAtencion = sc.nextLine();

                    Paciente paciente;

                    if (tipoPaciente.equalsIgnoreCase("P")) {
                        paciente = new PacientePreferencial(id, nombre, cedula, edad, seguro);
                    } else {
                        paciente = new PacienteNormal(id, nombre, cedula, edad, seguro);
                    }

                    Tiquete nuevo = new Tiquete(paciente, tipoAtencion, prioridad);

                    if (!nuevo.esValido()) {
                        System.out.println("Datos invalidos");
                        break;
                    }

                    gestorColas.registrarPaciente(nuevo);

                    System.out.println("Paciente registrado en cola");

                    break;

                // =====================================================
                // ATENDER PACIENTE
                // =====================================================
                case 2:

                    if (gestorColas.estaVacia()) {
                        System.out.println("No hay pacientes en cola");
                        break;
                    }

                    Tiquete t = gestorColas.siguientePaciente();

                    if (t != null) {
                        gestorSalas.asignarPaciente(t);
                    }

                    break;

              
                case 3:

                    if (gestorSalas.salasVacias()) {
                        System.out.println("No hay pacientes en salas");
                        break;
                    }

                    System.out.print("ID de Sala: ");
                    int idSala = sc.nextInt();
                    sc.nextLine();

                    Tiquete atendido = gestorSalas.atenderYRetornar(idSala);

                    if (atendido != null) {

                        System.out.print("Nombre del medico: ");
                        String medico = sc.nextLine();

                        gestorAtencion.registrarConsulta(atendido, medico);
                    }

                    break;

                case 4:

                    gestorAtencion.mostrarHistorial();
                    break;

                case 5:

                    gestorSalas.mostrarSalas();
                    break;

                case 6:

                    salir = true;
                    System.out.println("Sistema finalizado");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}

