import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private int id;
    private String nombre;
    private double presupuesto;
    private List<Tarea> tareas;

    public Proyecto(int id, String nombre, double presupuesto) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(int idTarea) {
        tareas.removeIf(t -> t.getId() == idTarea);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    @Override
    public String toString() {
        return "Proyecto: " + nombre + ", Presupuesto: " + presupuesto + ", Tareas: " + tareas.size();
    }
}
