package cr.ac.ufidelitas.mediqueue.main;

import cr.ac.ufidelitas.mediqueue.modulo1.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // =====================================================
        // LOGIN DEL SISTEMA 
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

        System.out.println("🚀 Sistema MediQueue iniciado (Modo pruebas)");

        // =====================================================
        // INICIALIZACIÓN DE SERVICIOS
        // =====================================================

        ConfigService service = new ConfigService();
        Configuracion config = service.cargar();

        // =====================================================
        // PRIMERA EJECUCIÓN DEL SISTEMA
        // =====================================================

        if (config == null) {
            System.out.println("⚙️ Configuración inicial");

            System.out.print("Nombre de la sede: ");
            String nombre = sc.nextLine();

            System.out.print("Cantidad de salas médicas: ");
            int salas = sc.nextInt();

            System.out.print("Cantidad de consultorios: ");
            int consultorios = sc.nextInt();

            System.out.print("Cantidad de emergencias: ");
            int emergencias = sc.nextInt();
            sc.nextLine();

            // Usuarios quemados (temporal)
            String[] usuarios = {"garias", "mchaves", "kartavia"};
            String[] passwords = {"70021", "50279", "80284"};

            Sede sede = new Sede(nombre, salas, consultorios, emergencias);

            config = new Configuracion(sede, usuarios, passwords);

            service.guardar(config);

            System.out.println("✅ Configuración guardada");
        }

        // =====================================================
        // CARGA NORMAL DEL SISTEMA
        // =====================================================

        System.out.println("🚀 MediQueue cargado correctamente");
        System.out.println("📍 Información de la sede:");
        System.out.println(config.getSede());

        // =====================================================
        // INICIO DE MÓDULOS DEL SISTEMA
        // =====================================================

       

    }
}
