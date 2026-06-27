package cr.ac.ufidelitas.mediqueue.modulo1;

public class Sede {

    private String nombre;
    private int salasMedicas;
    private int consultorios;
    private int emergencias;

      public Sede() {
      }
    
    public Sede(String nombre, int salasMedicas, int consultorios, int emergencias) {
        this.nombre = nombre;
        this.salasMedicas = salasMedicas;
        this.consultorios = consultorios;
        this.emergencias = emergencias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalasMedicas() {
        return salasMedicas;
    }

    public int getConsultorios() {
        return consultorios;
    }

    public int getEmergencias() {
        return emergencias;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "nombre='" + nombre + '\'' +
                ", salasMedicas=" + salasMedicas +
                ", consultorios=" + consultorios +
                ", emergencias=" + emergencias +
                '}';
    }
}
