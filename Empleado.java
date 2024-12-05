import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private int id;
    private String nombre;
    private String habilidades;
    private List<Tarea> tareasAsignadas;

    public Empleado(int id, String nombre, String habilidades) {
        this.id = id;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.tareasAsignadas = new ArrayList<>();
    }

    public void asignarTarea(Tarea tarea) {
        tareasAsignadas.add(tarea);
    }

    public List<Tarea> getTareasAsignadas() {
        return tareasAsignadas;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", Habilidades: " + habilidades + ", Tareas asignadas: " + tareasAsignadas.size();
    }
}
