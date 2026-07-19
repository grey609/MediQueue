package cr.ac.ufidelitas.mediqueue.modulo4;

import cr.ac.ufidelitas.mediqueue.estructuras.Cola;
import cr.ac.ufidelitas.mediqueue.modulo2.Tiquete;

public class Sala {

    private int id;
    private int capacidad;
    private String medico;
    private String enfermera;

    private Cola<Tiquete> cola;

    public Sala(int id, int capacidad, String medico, String enfermera) {
        this.id = id;
        this.capacidad = capacidad;
        this.medico = medico;
        this.enfermera = enfermera;
        this.cola = new Cola<>();
    }

    // =====================================================
    // GETTERS
    // =====================================================
    public int getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMedico() {
        return medico;
    }

    public String getEnfermera() {
        return enfermera;
    }

    // =====================================================
    // COLA INTERNA
    // =====================================================
    public void agregarPaciente(Tiquete t) {
        cola.encolar(t);
    }

    public Tiquete atender() {
        return cola.desencolar();
    }

    public boolean estaVacia() {
        return cola.estaVacia();
    }

    // =====================================================
    // CONTAR PACIENTES (SIN ARRAYLIST)
    // =====================================================
    public int getCantidadPacientes() {

        Cola<Tiquete> temp = new Cola<>();
        int count = 0;

        while (!cola.estaVacia()) {
            Tiquete t = cola.desencolar();
            temp.encolar(t);
            count++;
        }

        while (!temp.estaVacia()) {
            cola.encolar(temp.desencolar());
        }

        return count;
    }

    public boolean hayEspacio() {
        return getCantidadPacientes() < capacidad;
    }
}

